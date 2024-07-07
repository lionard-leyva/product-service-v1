package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public record DefaultProduct(
        Long id,
        String name,
        String description,
        Double price
) implements Product {

    @Override
    public String type() {
        return "Default";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(price);
    }
}