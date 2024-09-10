package com.oneclick.productservice.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oneclick.productservice.domain.strategy.PricingStrategy;

import java.math.BigDecimal;

@JsonTypeName("STANDARD")
public record StandardProduct(
        Long id,
        String name,
        String description,
        BigDecimal basePrice,
        PricingStrategy pricingStrategy

) implements Product {

    @Override
    public String type() {
        return "Standard";
    }

    @Override
    public BigDecimal getPrice() {
        return pricingStrategy.calculatePrice(basePrice);
    }
}