package com.inventory.control.stock.infrastructure.configuration;

import com.inventory.control.stock.adapters.persistence.mapper.ProductMapper;
import com.inventory.control.stock.adapters.persistence.mapper.StockMovementMapper;
import com.inventory.control.stock.adapters.persistence.repository.impl.ProductRepositoryJpaImpl;
import com.inventory.control.stock.adapters.persistence.repository.impl.StockMovementRepositoryJpaImpl;
import com.inventory.control.stock.adapters.persistence.repository.jpa.ProductRepositoryJpa;
import com.inventory.control.stock.adapters.persistence.repository.jpa.StockMovementRepositoryJpa;
import com.inventory.control.stock.core.domain.repository.ProductRepository;
import com.inventory.control.stock.core.domain.repository.StockMovementRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    ProductRepository productRepository(ProductRepositoryJpa productRepositoryJpa, ProductMapper productMapper){
        return new ProductRepositoryJpaImpl(productRepositoryJpa, productMapper);
    }

    @Bean
    StockMovementRepository stockMovementRepository(StockMovementRepositoryJpa stockMovementRepositoryJpa, StockMovementMapper stockMovementMapper) {
        return new StockMovementRepositoryJpaImpl(stockMovementRepositoryJpa, stockMovementMapper);
    }
}
