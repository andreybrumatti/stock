package com.inventory.control.stock.application.service;

import com.inventory.control.stock.application.usecase.product.CreateProductUseCase;
import com.inventory.control.stock.application.usecase.product.ProductCommand;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.repository.ProductRepository;

public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    @Override
    public Product create(ProductCommand productCommand) {

        Product product = Product.create(
                productCommand.name(),
                productCommand.description(),
                productCommand.unitPrice(),
                productCommand.currentStock()
        );
        return productRepository.save(product);
    }
}