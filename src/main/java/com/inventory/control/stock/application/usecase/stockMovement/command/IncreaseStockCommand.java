package com.inventory.control.stock.application.usecase.stockMovement.command;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

public record IncreaseStockCommand(
        Integer quantity,
        TypeMovement typeMovement
) {
}