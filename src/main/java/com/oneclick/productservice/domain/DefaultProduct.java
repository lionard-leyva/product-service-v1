package com.oneclick.productservice.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.math.BigDecimal;
@JsonTypeName("DEFAULT")
public record DefaultProduct(
        Long id,
        String name,
        String description,
        BigDecimal price
) implements Product {

    @Override
    public String type() {
        return "Default";
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}