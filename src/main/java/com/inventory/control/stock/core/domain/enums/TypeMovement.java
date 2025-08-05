package com.inventory.control.stock.core.domain.enums;

import static com.inventory.control.stock.core.domain.exception.TypeMovementException.invalidTypeMovementException;

public enum TypeMovement {
    IN("IN"),
    OUT("OUT");

    private final String value;

    TypeMovement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TypeMovement fromValue(String value) {
        for (TypeMovement type : TypeMovement.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw invalidTypeMovementException(TypeMovement.valueOf(value));
    }
}
