package com.oneclick.productservice.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.math.BigDecimal;

@JsonTypeName("STANDARD")
public record StandardProduct(
        Long id,
        String name,
        String description,
        BigDecimal price

) implements Product {

    @Override
    public String type() {
        return "Standard";
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}