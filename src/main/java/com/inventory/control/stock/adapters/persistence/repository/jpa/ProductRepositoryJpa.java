package com.inventory.control.stock.adapters.persistence.repository.jpa;

import com.inventory.control.stock.adapters.persistence.entity.ProductEntity;
import com.inventory.control.stock.core.domain.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, UUID>, ProductRepository {
}
