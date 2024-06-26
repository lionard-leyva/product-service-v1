package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public record BasicProduct(
        String id,
        String name,
        double price,
        String category
) implements Product {
    @Override
    public String toString() {
        return "BasicProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }
}
