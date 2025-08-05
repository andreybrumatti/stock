package com.inventory.control.stock.adapters.persistence.repository.impl;

import com.inventory.control.stock.adapters.persistence.entity.StockMovementEntity;
import com.inventory.control.stock.adapters.persistence.mapper.StockMovementMapper;
import com.inventory.control.stock.adapters.persistence.repository.jpa.StockMovementRepositoryJpa;
import com.inventory.control.stock.core.domain.model.StockMovement;
import com.inventory.control.stock.core.domain.repository.StockMovementRepository;

public class StockMovementRepositoryJpaImpl implements StockMovementRepository {

    private final StockMovementRepositoryJpa stockMovementRepositoryJpa;
    private final StockMovementMapper stockMovementMapper;

    public StockMovementRepositoryJpaImpl(StockMovementRepositoryJpa stockMovementRepositoryJpa, StockMovementMapper stockMovementMapper) {
        this.stockMovementRepositoryJpa = stockMovementRepositoryJpa;
        this.stockMovementMapper = stockMovementMapper;
    }

    @Override
    public StockMovement saveAndFlush(StockMovement stockMovement) {
        StockMovementEntity stockMovementEntity = stockMovementMapper.toEntity(stockMovement);
        StockMovementEntity stockMovementSaved = stockMovementRepositoryJpa.saveAndFlush(stockMovementEntity);

        return stockMovementMapper.toDomain(stockMovementSaved);
    }
}