package com.inventory.control.stock.infrastructure.controller.dto.product;

import java.math.BigDecimal;

public record ProductResponseDTO(
        String name,
        String description,
        BigDecimal unitPrice,
        Integer currentStock
) {
}
