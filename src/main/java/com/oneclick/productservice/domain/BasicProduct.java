package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public record BasicProduct(
        Long id,
        String name,
        String description,
        Double price
) implements Product {

    @Override
    public String type() {
        return "Basic";
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }
}