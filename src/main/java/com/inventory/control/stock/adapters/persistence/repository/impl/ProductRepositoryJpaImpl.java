package com.inventory.control.stock.adapters.persistence.repository.impl;

import com.inventory.control.stock.adapters.persistence.entity.ProductEntity;
import com.inventory.control.stock.adapters.persistence.mapper.ProductMapper;
import com.inventory.control.stock.adapters.persistence.repository.jpa.ProductRepositoryJpa;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.repository.ProductRepository;

public class ProductRepositoryJpaImpl implements ProductRepository {

    private final ProductRepositoryJpa productRepositoryJpa;
    private final ProductMapper productMapper;

    public ProductRepositoryJpaImpl(ProductRepositoryJpa productRepositoryJpa, ProductMapper productMapper) {
        this.productRepositoryJpa = productRepositoryJpa;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        ProductEntity savedProductEntity = productRepositoryJpa.save(productEntity);

        return productMapper.toDomain(savedProductEntity);
    }
}