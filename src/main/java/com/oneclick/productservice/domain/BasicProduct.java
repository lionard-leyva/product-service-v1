package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public record BasicProduct(
        Long id,
        String name,
        String description,
        Double price

)

        implements Product {
    @Override
    public String toString() {

        return "BasicProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +

                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public String type() {
        return "Basic";
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }
}
