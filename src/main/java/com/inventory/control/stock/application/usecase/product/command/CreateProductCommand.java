package com.inventory.control.stock.application.usecase.product.command;

import java.math.BigDecimal;

public record CreateProductCommand(
        String name,
        String description,
        BigDecimal unitPrice,
        Integer currentStock
) {
}