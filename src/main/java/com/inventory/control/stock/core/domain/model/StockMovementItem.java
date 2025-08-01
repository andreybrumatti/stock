package com.inventory.control.stock.core.domain.model;

import java.util.UUID;

public class StockMovementItem {
    private UUID id;
    private UUID stockMovementId;
    private UUID productId;
    private Integer quantity;

    public StockMovementItem(UUID stockMovementId, UUID productId, Integer quantity) {
        this.stockMovementId = stockMovementId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public UUID getStockMovementId() {
        return stockMovementId;
    }

    public UUID getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
