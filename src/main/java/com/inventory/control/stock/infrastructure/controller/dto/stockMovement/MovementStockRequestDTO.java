package com.inventory.control.stock.infrastructure.controller.dto.stockMovement;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

public record MovementStockRequestDTO(
        Integer quantity,
        TypeMovement typeMovement
) {
}