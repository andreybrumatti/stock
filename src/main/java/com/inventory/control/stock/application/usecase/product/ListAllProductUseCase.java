package com.inventory.control.stock.application.usecase.product;

import com.inventory.control.stock.core.domain.model.Product;

import java.util.List;

public interface ListAllProductUseCase {
    List<Product> listAllProducts();
}
