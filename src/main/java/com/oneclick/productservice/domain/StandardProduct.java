package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public record StandardProduct(
        Long id,
        String name,
        String description,
        Double price


) implements Product {
    @Override
    public String toString() {
        return "StandardProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +

                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public String type() {
        return "Standard";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(price);
    }
}

