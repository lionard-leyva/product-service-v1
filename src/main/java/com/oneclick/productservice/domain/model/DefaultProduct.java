package com.oneclick.productservice.domain.model;

import java.math.BigDecimal;

public record DefaultProduct(
        String name,
        String description,
        BigDecimal basePrice,
        BigDecimal finalPrice
) implements Product {
    @Override
    public ProductType type() {
        return ProductType.DEFAULT;
    }
    @Override
    public BigDecimal price(){
        return finalPrice != null ? finalPrice : basePrice;
    }
}
