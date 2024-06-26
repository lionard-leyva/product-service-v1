package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public record StandardProduct(
        String id,
        String name,
        double price,
        String category,
        String description
) implements Product {
    @Override
    public String toString() {
        return "StandardProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }
}

