package com.inventory.control.stock.application.usecase.product;

import java.math.BigDecimal;

public record ProductCommand(
        String name,
        String description,
        BigDecimal unitPrice,
        Integer currentStock
) {
}