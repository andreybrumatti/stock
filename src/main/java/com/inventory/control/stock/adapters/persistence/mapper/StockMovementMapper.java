package com.inventory.control.stock.adapters.persistence.mapper;

import com.inventory.control.stock.adapters.persistence.entity.StockMovementEntity;
import com.inventory.control.stock.application.usecase.stockMovement.command.MovementStockCommand;
import com.inventory.control.stock.core.domain.model.StockMovement;
import com.inventory.control.stock.infrastructure.controller.dto.stockMovement.MovementStockRequestDTO;
import com.inventory.control.stock.infrastructure.controller.dto.stockMovement.MovementStockResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface StockMovementMapper {
    @Mapping(target = "product", source = "productEntity")
    StockMovement toDomain(StockMovementEntity stockMovementEntity);

    @Mapping(target = "productEntity", source = "product")
    StockMovementEntity toEntity(StockMovement stockMovement);

    MovementStockCommand toCommand(MovementStockRequestDTO movementStockRequestDTO);

    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "quantity", source = "product.currentStock")
    MovementStockResponseDTO toResponseDTO(StockMovement stockMovement);
}