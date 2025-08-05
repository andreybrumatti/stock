package com.inventory.control.stock.infrastructure.controller.dto.stockMovement;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

import java.time.OffsetDateTime;
import java.util.UUID;

public record MovementStockResponseDTO(
    UUID id,
    String name,
    Integer quantity,
    TypeMovement typeMovement,
    OffsetDateTime movementDate
) {
}