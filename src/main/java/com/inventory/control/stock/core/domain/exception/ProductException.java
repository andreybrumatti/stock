package com.inventory.control.stock.core.domain.exception;

import com.inventory.control.stock.core.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductException extends RuntimeException{
    public ProductException(String message) {
        super(message);
    }

    public static ProductException invalidUnitPriceException(BigDecimal unitPrice) {
        return new ProductException("Unit price must be greater than zero: " + unitPrice);
    }

    public static ProductException invalidStockQuantityException(Integer currentStock) {
        return new ProductException("Stock cannot be negative: " + currentStock);
    }

    public static ProductException invalidStockQuantityDecrease(Integer quantity) {
        return new ProductException("Cannot decrease stock to a negative value: " + quantity);
    }

    public static ProductException invalidProductNameException(String name) {
        return new ProductException("Product name cannot be null or empty: " + name);
    }

    public static ProductException invalidProductDescriptionException(String description) {
        return new ProductException("Product description cannot be null or empty: " + description);
    }

    public static ProductException productNotFoundException(UUID id) {
        return new ProductException("Product not found with id: " + id);
    }
}
