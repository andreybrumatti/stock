package com.inventory.control.stock.application.service.product;

import com.inventory.control.stock.application.usecase.product.command.CreateProductCommand;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateProductService createProductService;

    @Test
    @DisplayName("Should create product with sucess")
    void shouldCreateProductWithSuccess() {
        Product productExpected = Product.create(
                "Notebook",
                "Top de linha",
                new BigDecimal(2500),
                5
        );

        CreateProductCommand createProductCommand = new CreateProductCommand(
                "Notebook",
                "Top de linha",
                new BigDecimal(2500),
                5
        );

        when(productRepository.save(any(Product.class))).thenReturn(productExpected);

        Product productSave = createProductService.create(createProductCommand);

        verify(productRepository, times(1)).save(any(Product.class));
        assertEquals("Notebook", productSave.getName());
        assertEquals("Top de linha", productSave.getDescription());
        assertEquals(new BigDecimal(2500), productSave.getUnitPrice());
        assertEquals(5, productSave.getCurrentStock());
    }
}