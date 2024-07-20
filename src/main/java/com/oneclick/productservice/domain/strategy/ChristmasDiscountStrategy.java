package com.oneclick.productservice.domain.strategy;

import java.math.BigDecimal;

public class ChristmasDiscountStrategy implements PricingStrategy {
    private static final BigDecimal DISCOUNT = new BigDecimal("0.9");

    @Override
    public BigDecimal calculatePrice(BigDecimal basePrice) {
        return basePrice.multiply(DISCOUNT);
    }
}
