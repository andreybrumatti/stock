package com.inventory.control.stock.infrastructure.configuration;

import com.inventory.control.stock.application.service.product.CreateProductService;
import com.inventory.control.stock.application.service.product.ListAllProductService;
import com.inventory.control.stock.application.service.stockMovement.DecreaseStockProductService;
import com.inventory.control.stock.application.service.stockMovement.IncreaseStockProductService;
import com.inventory.control.stock.application.usecase.product.CreateProductUseCase;
import com.inventory.control.stock.application.usecase.product.ListAllProductUseCase;
import com.inventory.control.stock.application.usecase.stockMovement.DecreaseStockProductUseCase;
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

    @Bean
    public DecreaseStockProductUseCase decreaseStockProductUseCase(ProductRepository productRepository, StockMovementRepository stockMovementRepository) {
        return new DecreaseStockProductService(productRepository, stockMovementRepository);
    }

    @Bean
    ListAllProductUseCase listAllProductUseCase(ProductRepository productRepository) {
        return new ListAllProductService(productRepository);
    }
}