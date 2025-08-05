package com.inventory.control.stock.core.domain.repository;

import com.inventory.control.stock.core.domain.exception.ProductException;
import com.inventory.control.stock.core.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(UUID productId) throws ProductException;
}