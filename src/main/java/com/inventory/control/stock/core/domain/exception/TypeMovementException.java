package com.inventory.control.stock.core.domain.exception;

public class TypeMovementException extends RuntimeException {
    public TypeMovementException(String message) {
        super(message);
    }

    public static TypeMovementException invalidTypeMovementException(String typeMovement) {
        return new TypeMovementException("Invalid type movement: " + typeMovement);
    }
}
