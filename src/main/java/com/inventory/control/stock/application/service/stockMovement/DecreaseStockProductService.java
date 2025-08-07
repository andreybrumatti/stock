package com.inventory.control.stock.application.service.stockMovement;

import com.inventory.control.stock.application.usecase.stockMovement.DecreaseStockProductUseCase;
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

public class DecreaseStockProductService implements DecreaseStockProductUseCase {

    private final ProductRepository productRepository;
    private final StockMovementRepository stockMovementRepository;

    public DecreaseStockProductService(ProductRepository productRepository, StockMovementRepository stockMovementRepository) {
        this.productRepository = productRepository;
        this.stockMovementRepository = stockMovementRepository;
    }

    @Override
    @Transactional
    public StockMovement decreaseStock(UUID productId, MovementStockCommand movementStockCommand) throws TypeMovementException {

        TypeMovement typeMovement = movementStockCommand.typeMovement();

        if (typeMovement != TypeMovement.OUT) {
            throw TypeMovementException.invalidTypeMovementException(typeMovement);
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> ProductException.productNotFoundException(productId));

        product.decreaseStock(movementStockCommand.quantity());

        StockMovement stockMovement = StockMovement.create(
                typeMovement,
                product
        );

        productRepository.save(product);
        return stockMovementRepository.saveAndFlush(stockMovement);
    }
}
