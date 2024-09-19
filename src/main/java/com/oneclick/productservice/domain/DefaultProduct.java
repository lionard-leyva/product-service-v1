package com.oneclick.productservice.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oneclick.productservice.domain.strategy.PricingStrategy;

import java.math.BigDecimal;

@JsonTypeName("DEFAULT")
public record DefaultProduct(
        Long id,
        String name,
        String description,
        BigDecimal basePrice,
        BigDecimal finalPrice
) implements Product {

    @Override
    public String type() {
        return "Basic";
    }

    @Override
    public BigDecimal getPrice() {
        return finalPrice != null ? finalPrice : basePrice;
    }
}