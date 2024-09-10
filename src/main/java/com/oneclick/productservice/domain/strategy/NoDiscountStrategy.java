package com.oneclick.productservice.domain.strategy;

import java.math.BigDecimal;

public class NoDiscountStrategy implements PricingStrategy{
    @Override
    public BigDecimal calculatePrice(BigDecimal basePrice) {
        return basePrice;
    }
}