package com.oneclick.productservice.domain.strategy;

import java.math.BigDecimal;

public class RegularPricingStrategy implements PricingStrategy{

    @Override
    public BigDecimal calculatePrice(BigDecimal basePrice) {
        return basePrice;
    }
}
