package com.inventory.control.stock.application.usecase.stockMovement.command;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

public record MovementStockCommand(
        Integer quantity,
        TypeMovement typeMovement
) {
}