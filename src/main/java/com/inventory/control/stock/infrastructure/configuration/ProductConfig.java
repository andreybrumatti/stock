package com.inventory.control.stock.infrastructure.configuration;

import com.inventory.control.stock.application.service.CreateProductService;
import com.inventory.control.stock.application.service.IncreaseStockProductService;
import com.inventory.control.stock.application.usecase.product.CreateProductUseCase;
import com.inventory.control.stock.application.usecase.stockMovement.IncreaseStockProductUseCase;
import com.inventory.control.stock.core.domain.repository.ProductRepository;
import com.inventory.control.stock.core.domain.repository.StockMovementRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository productRepository) {
        return new CreateProductService(productRepository);
    }

    @Bean
    public IncreaseStockProductUseCase increaseStockProductUseCase(ProductRepository productRepository, StockMovementRepository stockMovementRepository) {
        return new IncreaseStockProductService(productRepository, stockMovementRepository);
    }

}