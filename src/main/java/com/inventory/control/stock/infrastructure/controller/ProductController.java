package com.inventory.control.stock.infrastructure.controller;

import com.inventory.control.stock.adapters.persistence.mapper.ProductMapper;
import com.inventory.control.stock.adapters.persistence.mapper.StockMovementMapper;
import com.inventory.control.stock.application.usecase.product.CreateProductUseCase;
import com.inventory.control.stock.application.usecase.product.ListAllProductUseCase;
import com.inventory.control.stock.application.usecase.product.command.CreateProductCommand;
import com.inventory.control.stock.application.usecase.stockMovement.DecreaseStockProductUseCase;
import com.inventory.control.stock.application.usecase.stockMovement.IncreaseStockProductUseCase;
import com.inventory.control.stock.application.usecase.stockMovement.command.MovementStockCommand;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.core.domain.model.StockMovement;
import com.inventory.control.stock.infrastructure.controller.dto.stockMovement.MovementStockRequestDTO;
import com.inventory.control.stock.infrastructure.controller.dto.stockMovement.MovementStockResponseDTO;
import com.inventory.control.stock.infrastructure.controller.dto.product.ProductResponseDTO;
import com.inventory.control.stock.infrastructure.controller.dto.product.ProductResquestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final IncreaseStockProductUseCase increaseStockProductUseCase;
    private final DecreaseStockProductUseCase decreaseStockProductUseCase;
    private final ListAllProductUseCase listAllProductUseCase;
    private final ProductMapper productMapper;
    private final StockMovementMapper stockMovementMapper;

    @PostMapping("/create")
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductResquestDTO productRequestDTO) {
        CreateProductCommand createProductCommand = productMapper.toCommand(productRequestDTO);
        Product product = createProductUseCase.create(createProductCommand);

        return productMapper.toResponseDTO(product);
    }

    @PostMapping("/increase-stock/{productId}")
    public MovementStockResponseDTO increaseStock(@Valid @PathVariable UUID productId,
                                                  @RequestBody MovementStockRequestDTO movementStockRequestDTO) {
        MovementStockCommand movementStockCommand = stockMovementMapper.toCommand(movementStockRequestDTO);
        StockMovement stockMovement = increaseStockProductUseCase.increaseStock(productId, movementStockCommand);

        return stockMovementMapper.toResponseDTO(stockMovement);
    }

    @PostMapping("/decrease-stock/{productId}")
    public MovementStockResponseDTO decreaseStock(@Valid @PathVariable UUID productId,
                                                  @RequestBody MovementStockRequestDTO movementStockRequestDTO) {
        MovementStockCommand movementStockCommand = stockMovementMapper.toCommand(movementStockRequestDTO);
        StockMovement stockMovement = decreaseStockProductUseCase.decreaseStock(productId, movementStockCommand);

        return stockMovementMapper.toResponseDTO(stockMovement);
    }

    @GetMapping("list-all")
    public List<Product> listAllProducts() {
        return listAllProductUseCase.listAllProducts();
    }

 }