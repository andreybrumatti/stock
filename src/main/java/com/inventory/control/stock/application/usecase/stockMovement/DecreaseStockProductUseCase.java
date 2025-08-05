package com.inventory.control.stock.application.usecase.stockMovement;

import com.inventory.control.stock.application.usecase.stockMovement.command.MovementStockCommand;
import com.inventory.control.stock.core.domain.exception.TypeMovementException;
import com.inventory.control.stock.core.domain.model.StockMovement;

import java.util.UUID;

public interface DecreaseStockProductUseCase {
    StockMovement decreaseStock(UUID productId, MovementStockCommand movementStockCommand) throws TypeMovementException;
}