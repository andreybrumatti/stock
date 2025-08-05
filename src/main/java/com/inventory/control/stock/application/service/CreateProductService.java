package com.inventory.control.stock.application.service;

import com.inventory.control.stock.application.usecase.product.command.CreateProductCommand;
import com.inventory.control.stock.application.usecase.product.CreateProductUseCase;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    @Override
    @Transactional
    public Product create(CreateProductCommand createProductCommand) {

        Product product = Product.create(
                createProductCommand.name(),
                createProductCommand.description(),
                createProductCommand.unitPrice(),
                createProductCommand.currentStock()
        );
        return productRepository.save(product);
    }
}