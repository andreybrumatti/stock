package com.inventory.control.stock.application.service.stockMovement;

import com.inventory.control.stock.application.usecase.stockMovement.command.MovementStockCommand;
import com.inventory.control.stock.core.domain.enums.TypeMovement;
import com.inventory.control.stock.core.domain.exception.ProductException;
import com.inventory.control.stock.core.domain.exception.TypeMovementException;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.model.StockMovement;
import com.inventory.control.stock.core.domain.repository.ProductRepository;
import com.inventory.control.stock.core.domain.repository.StockMovementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DecreaseStockProductServiceTest {

    private Product productTest;
    private MovementStockCommand movementStockCommand;
    private UUID productId;
    private StockMovement stockMovement;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockMovementRepository stockMovementRepository;

    @InjectMocks
    private  DecreaseStockProductService decreaseStockProductService;

    @Captor
    private ArgumentCaptor<StockMovement> captor;

    @BeforeEach
    void setUp() {
        productTest = Product.create(
                "Produto teste",
                "teste",
                new BigDecimal(10),
                5
        );

        movementStockCommand = new MovementStockCommand(
                2,
                TypeMovement.valueOf("OUT")
        );

        productId = productTest.getId();

        stockMovement = StockMovement.create(
                movementStockCommand.typeMovement(),
                productTest
        );
    }

    @Test
    @DisplayName("Should throw type movement exception case typeMovement value is different from OUT")
    void shouldThrowTypeMovementException() {
       MovementStockCommand movementStockCommandException = new MovementStockCommand(
                2,
                TypeMovement.valueOf("IN")
        );

        assertThrows(TypeMovementException.class,
                () -> decreaseStockProductService.decreaseStock(productId, movementStockCommandException));
    }

    @Test
    @DisplayName("Should throw product exception case the product return empty")
    void shouldThrowProductException() {
        doReturn(Optional.empty()).when(productRepository).findById(productId);

        assertThrows(ProductException.class,
                () -> decreaseStockProductService.decreaseStock(productId, movementStockCommand));

        verify(productRepository, times(0)).save(any());
        verify(stockMovementRepository, times(0)).saveAndFlush(any());
    }

    @Test
    @DisplayName("Should decrease in product stock with success")
    void shouldDecreaseInProductStock() {
        when(productRepository.findById(productId)).thenReturn(Optional.of(productTest));
        when(stockMovementRepository.saveAndFlush(any(StockMovement.class))).thenReturn(stockMovement);

        StockMovement stockMovementSave = decreaseStockProductService.decreaseStock(productId, movementStockCommand);

        verify(productRepository).findById(productId);
        verify(productRepository).save(any(Product.class));
        verify(stockMovementRepository).saveAndFlush(captor.capture());

        StockMovement stockMovementCapture = captor.getValue();

        assertEquals(3, stockMovementSave.getProduct().getCurrentStock());
        assertEquals(stockMovementSave.getProduct(), stockMovementCapture.getProduct());
        assertEquals(stockMovementSave.getTypeMovement(), stockMovementCapture.getTypeMovement());
        assertNotNull(stockMovementSave.getMovementDate());
    }
}