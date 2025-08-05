package com.inventory.control.stock.infrastructure.controller.dto;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

public record IncreaseStockRequestDTO(
        Integer quantity,
        TypeMovement typeMovement
) {
}