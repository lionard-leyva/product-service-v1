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
}