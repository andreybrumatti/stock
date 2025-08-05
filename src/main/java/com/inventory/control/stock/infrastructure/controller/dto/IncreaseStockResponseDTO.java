package com.inventory.control.stock.infrastructure.controller.dto;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

import java.time.OffsetDateTime;
import java.util.UUID;

public record IncreaseStockResponseDTO(
    UUID id,
    String name,
    TypeMovement typeMovement,
    OffsetDateTime movementDate
) {
}
