package com.oneclick.productservice.domain.model;

import java.math.BigDecimal;


public sealed interface Product
        permits BasicProduct,
        DefaultProduct,
        StandardProduct {

    String name();
    String description();
    BigDecimal price();
    BigDecimal finalPrice();
    ProductType type();

    default Product updateFinalPrice(BigDecimal finalPrice) {
        return switch (this) {
            case BasicProduct p -> new BasicProduct(p.name(), p.description(), p.price(), finalPrice);
            case StandardProduct p -> new StandardProduct(p.name(), p.description(), p.price(), finalPrice);
            case DefaultProduct p -> new DefaultProduct(p.name(), p.description(), p.price(), finalPrice);
        };
    }
}