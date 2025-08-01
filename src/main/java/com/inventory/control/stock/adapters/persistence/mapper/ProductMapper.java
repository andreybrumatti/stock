package com.inventory.control.stock.adapters.persistence.mapper;

import com.inventory.control.stock.application.usecase.product.ProductCommand;
import com.inventory.control.stock.core.domain.model.Product;
import com.inventory.control.stock.infrastructure.controller.dto.ProductResponseDTO;
import com.inventory.control.stock.infrastructure.controller.dto.ProductResquestDTO;
import com.inventory.control.stock.adapters.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
    }
    ProductCommand toCommand(ProductResquestDTO productRequestDTO);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "unitPrice", source = "unitPrice")
    @Mapping(target = "currentStock", source = "currentStock")
    ProductResponseDTO toResponseDTO(Product product);
}