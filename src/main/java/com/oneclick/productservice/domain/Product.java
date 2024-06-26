package com.oneclick.productservice.domain;

import java.math.BigDecimal;

public sealed interface Product permits
        StandardProduct,
        BasicProduct,
        DefaultProduct {
    BigDecimal getPrice();
}
