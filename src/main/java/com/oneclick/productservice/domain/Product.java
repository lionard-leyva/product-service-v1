package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public sealed interface Product permits BasicProduct, DefaultProduct, StandardProduct {
    Long id();

    String name();

    String description();

    Double price();

    String type();

    BigDecimal getPrice();
}

