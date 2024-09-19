package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public record Pricing(Long productId, BigDecimal calculatedPrice) {
    public Pricing {
        if (calculatedPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
}