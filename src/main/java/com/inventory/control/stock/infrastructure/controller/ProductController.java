package com.inventory.control.stock.infrastructure.controller;

import com.inventory.control.stock.adapters.persistence.mapper.ProductMapper;
import com.inventory.control.stock.adapters.persistence.mapper.StockMovementMapper;
import com.inventory.control.stock.application.usecase.product.CreateProductUseCase;
import com.inventory.control.stock.application.usecase.product.command.CreateProductCommand;
import com.inventory.control.stock.application.usecase.stockMovement.IncreaseStockProductUseCase;
import com.inventory.control.stock.application.usecase.stockMovement.command.IncreaseStockCommand;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.model.StockMovement;
import com.inventory.control.stock.infrastructure.controller.dto.IncreaseStockRequestDTO;
import com.inventory.control.stock.infrastructure.controller.dto.IncreaseStockResponseDTO;
import com.inventory.control.stock.infrastructure.controller.dto.ProductResponseDTO;
import com.inventory.control.stock.infrastructure.controller.dto.ProductResquestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final IncreaseStockProductUseCase increaseStockProductUseCase;
    private final ProductMapper productMapper;
    private final StockMovementMapper stockMovementMapper;

    @PostMapping("/create")
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductResquestDTO productRequestDTO) {
        CreateProductCommand createProductCommand = productMapper.toCommand(productRequestDTO);
        Product product = createProductUseCase.create(createProductCommand);

        return productMapper.toResponseDTO(product);
    }

    @PostMapping("/increase-stock/{productId}")
    public IncreaseStockResponseDTO increaseStock(@Valid @PathVariable UUID productId,
                                                  @RequestBody IncreaseStockRequestDTO increaseStockRequestDTO) {
        IncreaseStockCommand increaseStockCommand = stockMovementMapper.toCommand(increaseStockRequestDTO);
        StockMovement stockMovement = increaseStockProductUseCase.increaseStock(productId, increaseStockCommand);

        return stockMovementMapper.toResponseDTO(stockMovement);
    }
 }