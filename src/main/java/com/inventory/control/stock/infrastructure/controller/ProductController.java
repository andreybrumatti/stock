package com.inventory.control.stock.infrastructure.controller;

import com.inventory.control.stock.adapters.persistence.mapper.ProductMapper;
import com.inventory.control.stock.application.usecase.product.CreateProductUseCase;
import com.inventory.control.stock.application.usecase.product.ProductCommand;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.infrastructure.controller.dto.ProductResponseDTO;
import com.inventory.control.stock.infrastructure.controller.dto.ProductResquestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ProductMapper productMapper;

    @PostMapping("/create")
    public ProductResponseDTO createProduct(@RequestBody ProductResquestDTO productRequestDTO) {
        ProductCommand productCommand = productMapper.toCommand(productRequestDTO);
        Product product = createProductUseCase.create(productCommand);

        return productMapper.toResponseDTO(product);
    }
}
