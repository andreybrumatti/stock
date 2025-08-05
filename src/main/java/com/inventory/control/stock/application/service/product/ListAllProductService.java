package com.inventory.control.stock.application.service.product;

import com.inventory.control.stock.application.usecase.product.ListAllProductUseCase;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.repository.ProductRepository;

import java.util.List;

public class ListAllProductService implements ListAllProductUseCase {

    private final ProductRepository productRepository;

    public ListAllProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }
}
