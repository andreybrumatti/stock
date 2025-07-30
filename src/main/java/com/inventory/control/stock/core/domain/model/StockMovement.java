package com.inventory.control.stock.core.domain.model;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

import java.time.OffsetDateTime;
import java.util.UUID;

public class StockMovement {
    private UUID id;
    private TypeMovement typeMovement;
    private OffsetDateTime movementDate;

    public StockMovement(TypeMovement typeMovement, OffsetDateTime movementDate) {
        this.typeMovement = typeMovement;
        this.movementDate = movementDate;
    }

    public void updateStockMovement(String typeMovement) {
        this.typeMovement = TypeMovement.fromValue(typeMovement);
        this.movementDate = OffsetDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public TypeMovement getTypeMovement() {
        return typeMovement;
    }

    public OffsetDateTime getMovementDate() {
        return movementDate;
    }
}
