package com.oneclick.productservice.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.math.BigDecimal;
@JsonTypeName("BASIC")
public record BasicProduct(
        Long id,
        String name,
        String description,
        BigDecimal price
) implements Product {

    @Override
    public String type() {
        return "Basic";
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}