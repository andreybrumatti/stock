package com.inventory.control.stock.application.service.product;

import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListAllProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ListAllProductService listAllProductService;

    @Test
    @DisplayName("Should list all products with sucess")
    void shouldListAllProductsWithSuccess() {

        Product product1 = Product.create(
                "Notebook Azus",
                "Very good",
                new BigDecimal(3000),
                5
        );
        Product product2 = Product.create(
                "Notebook Dell",
                "Very beautiful",
                new BigDecimal(6000),
                2
        );

        List<Product> productList = List.of(product1, product2);

        doReturn(productList).when(productRepository).findAll();

        List<Product> productsReturned = listAllProductService.listAllProducts();

        verify(productRepository, times(1)).findAll();
        assertEquals(2, productsReturned.size());
        assertNotNull(productsReturned);
    }

    @Test
    @DisplayName("Should list all products empty")
    void shouldListAllProductsEmpty() {

        List<Product> productList = List.of();

        doReturn(productList).when(productRepository).findAll();

        List<Product> productsReturned = listAllProductService.listAllProducts();

        verify(productRepository, times(1)).findAll();
        assertEquals(0, productsReturned.size());
        assertTrue(productsReturned.isEmpty());
    }
}