package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public record DefaultProduct(String id,
                             String name,
                             double price,
                             String category)
        implements Product {
    @Override
    public String toString() {
        return "DefaultProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(price);
    }
}
