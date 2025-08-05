package com.inventory.control.stock.adapters.persistence.repository.jpa;

import com.inventory.control.stock.adapters.persistence.entity.StockMovementEntity;
import com.inventory.control.stock.core.domain.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockMovementRepositoryJpa extends JpaRepository<StockMovementEntity, UUID> {
}
