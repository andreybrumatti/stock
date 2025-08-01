package com.inventory.control.stock.core.domain.repository;

import com.inventory.control.stock.core.domain.model.Product;

public interface ProductRepository {
    Product save(Product product);
}