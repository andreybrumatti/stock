package com.inventory.control.stock.application.usecase.stockMovement;

import com.inventory.control.stock.application.usecase.stockMovement.command.IncreaseStockCommand;
import com.inventory.control.stock.core.domain.model.StockMovement;

import java.util.UUID;

public interface IncreaseStockProductUseCase {
    StockMovement increaseStock(UUID productId, IncreaseStockCommand increaseStockCommand);
}