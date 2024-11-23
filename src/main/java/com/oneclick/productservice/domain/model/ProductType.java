package com.oneclick.productservice.domain.model;

public enum ProductType {
    BASIC,
    DEFAULT,
    STANDARD;

    public String getValue() {
        return this.name();
    }

    public static ProductType fromString(String type) {
        try {
            return ProductType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}
