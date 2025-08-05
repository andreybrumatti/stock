package com.inventory.control.stock.infrastructure.controller.dto.product;

import java.math.BigDecimal;

public record ProductResquestDTO(
        String name,
        String description,
        BigDecimal unitPrice,
        Integer currentStock
) {
}
