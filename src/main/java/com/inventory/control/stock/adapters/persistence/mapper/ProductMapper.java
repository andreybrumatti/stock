package com.inventory.control.stock.adapters.persistence.mapper;

import com.inventory.control.stock.application.usecase.product.command.CreateProductCommand;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.infrastructure.controller.dto.ProductResponseDTO;
import com.inventory.control.stock.infrastructure.controller.dto.ProductResquestDTO;
import com.inventory.control.stock.adapters.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(Product product);
    default Product toDomain(ProductEntity productEntity) {
        return Product.fromEntity(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getUnitPrice(),
                productEntity.getCurrentStock(),
                productEntity.getCreatedAt(),
                productEntity.getUpdatedAt()
        );
    };
    CreateProductCommand toCommand(ProductResquestDTO productRequestDTO);
    ProductResponseDTO toResponseDTO(Product product);
}