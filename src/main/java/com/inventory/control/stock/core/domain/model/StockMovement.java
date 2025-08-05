package com.inventory.control.stock.core.domain.model;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

import java.time.OffsetDateTime;
import java.util.UUID;

public class StockMovement {
    private UUID id;
    private Product product;
    private TypeMovement typeMovement;
    private OffsetDateTime movementDate;

    public StockMovement(UUID id, Product product, TypeMovement typeMovement, OffsetDateTime movementDate) {
        this.id = id;
        this.product = product;
        this.typeMovement = typeMovement;
        this.movementDate = movementDate;
    }

    public static StockMovement create(TypeMovement typeMovement, Product product){
        return new StockMovement(
                UUID.randomUUID(),
                product,
                typeMovement,
                OffsetDateTime.now()
        );
    }

    public static StockMovement fromEntity(UUID id,Product product, TypeMovement typeMovement, OffsetDateTime movementDate) {
        return new StockMovement(
                id,
                product,
                typeMovement,
                movementDate
        );
    }

    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public TypeMovement getTypeMovement() {
        return typeMovement;
    }

    public OffsetDateTime getMovementDate() {
        return movementDate;
    }
}
