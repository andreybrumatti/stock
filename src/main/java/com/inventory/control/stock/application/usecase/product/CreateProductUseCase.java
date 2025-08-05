package com.inventory.control.stock.application.usecase.product;

import com.inventory.control.stock.application.usecase.product.command.CreateProductCommand;
import com.inventory.control.stock.core.domain.model.Product;

public interface CreateProductUseCase {
    Product create(CreateProductCommand createProductCommand);
}