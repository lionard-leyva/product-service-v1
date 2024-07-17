package com.oneclick.productservice.domain.strategy;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(BigDecimal basePrice);
}
