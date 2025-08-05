package com.inventory.control.stock.core.domain.repository;

import com.inventory.control.stock.core.domain.model.StockMovement;

public interface StockMovementRepository {
    StockMovement saveAndFlush(StockMovement stockMovement);
}