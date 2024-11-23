package com.oneclick.productservice.domain.model;

import java.math.BigDecimal;

public record StandardProduct(
        String name,
        String description,
        BigDecimal basePrice,
        BigDecimal finalPrice
) implements Product {
    @Override
    public ProductType type() {
        return ProductType.STANDARD;
}

    @Override
    public BigDecimal price() {
        return finalPrice != null ? finalPrice : basePrice;
    }
}
