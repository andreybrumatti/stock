package com.inventory.control.stock.application.service.stockMovement;

import com.inventory.control.stock.application.usecase.stockMovement.IncreaseStockProductUseCase;
import com.inventory.control.stock.application.usecase.stockMovement.command.MovementStockCommand;
import com.inventory.control.stock.core.domain.enums.TypeMovement;
import com.inventory.control.stock.core.domain.exception.ProductException;
import com.inventory.control.stock.core.domain.exception.TypeMovementException;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.model.StockMovement;
import com.inventory.control.stock.core.domain.repository.ProductRepository;
import com.inventory.control.stock.core.domain.repository.StockMovementRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class IncreaseStockProductService implements IncreaseStockProductUseCase {

    private final ProductRepository productRepository;
    private final StockMovementRepository stockMovementRepository;

    public IncreaseStockProductService(ProductRepository productRepository, StockMovementRepository stockMovementRepository) {
        this.productRepository = productRepository;
        this.stockMovementRepository = stockMovementRepository;
    }

    @Override
    @Transactional
    public StockMovement increaseStock(UUID productId, MovementStockCommand movementStockCommand) {

        TypeMovement typeMovement = movementStockCommand.typeMovement();

        if (typeMovement != TypeMovement.IN) {
            throw TypeMovementException.invalidTypeMovementException(typeMovement);
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> ProductException.productNotFoundException(productId));

        product.increaseStock(movementStockCommand.quantity());

        StockMovement stockMovement = StockMovement.create(
                movementStockCommand.typeMovement(),
                product
        );

        productRepository.save(product);
        return stockMovementRepository.saveAndFlush(stockMovement);
    }
}