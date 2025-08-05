package com.inventory.control.stock.core.domain.exception;

import com.inventory.control.stock.core.domain.enums.TypeMovement;

public class TypeMovementException extends RuntimeException {
    public TypeMovementException(String message) {
        super(message);
    }

    public static TypeMovementException invalidTypeMovementException(TypeMovement typeMovement) {
        return new TypeMovementException("Invalid type movement: " + typeMovement);
    }
}
