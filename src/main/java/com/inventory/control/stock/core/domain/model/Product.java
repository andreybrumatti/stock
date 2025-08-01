package com.inventory.control.stock.core.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.inventory.control.stock.core.domain.exception.ProductException.*;

public class Product {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private Integer currentStock;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    private Product(UUID id, String name, String description, BigDecimal unitPrice, Integer currentStock,
                   OffsetDateTime createdAt, OffsetDateTime updatedAt) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.currentStock = currentStock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Product create(String name, String description, BigDecimal unitPrice, Integer currentStock) {

        if (unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw invalidUnitPriceException(unitPrice);
        }
        if (currentStock < 0) {
            throw invalidStockQuantityException(currentStock);
        }
        if (name == null || name.isBlank()) {
            throw invalidProductNameException(name);
        }

        if (description == null || description.isBlank()) {
            throw invalidProductDescriptionException(description);
        }

        OffsetDateTime now = OffsetDateTime.now();
        return new Product(
                UUID.randomUUID(),
                name,
                description,
                unitPrice,
                currentStock,
                now,
                now
        );
    }

    public static Product fromEntity(UUID id, String name, String description, BigDecimal unitPrice, Integer currentStock, OffsetDateTime createdAt, OffsetDateTime updatedAt){
        return new Product(
                id,
                name,
                description,
                unitPrice,
                currentStock,
                createdAt,
                updatedAt
        );
    }

    public void updateUnitPrice(BigDecimal unitPrice) {
        if(unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw invalidUnitPriceException(unitPrice);
        }
        this.unitPrice = unitPrice;
        this.updatedAt = OffsetDateTime.now();
    }

    public void increaseStock(Integer quantity) {
        if (quantity < 0) {
            throw invalidStockQuantityException(quantity);
        }
        this.currentStock += quantity;
        this.updatedAt = OffsetDateTime.now();
    }

    public void decreaseStock(Integer quantity) {
        if (quantity < 0) {
            throw invalidStockQuantityException(quantity);
        }
        if (this.currentStock < quantity) {
            throw invalidStockQuantityDecrease(quantity);
        }

        this.currentStock -= quantity;
        this.updatedAt = OffsetDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}
