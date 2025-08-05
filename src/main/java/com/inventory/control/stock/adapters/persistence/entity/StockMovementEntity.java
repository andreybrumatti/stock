package com.inventory.control.stock.adapters.persistence.entity;

import com.inventory.control.stock.core.domain.enums.TypeMovement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockMovementEntity {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeMovement typeMovement;

    private OffsetDateTime movementDate;
}
