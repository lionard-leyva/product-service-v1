package com.oneclick.productservice.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BasicProduct.class, name = "BASIC"),
        @JsonSubTypes.Type(value = DefaultProduct.class, name = "DEFAULT"),
        @JsonSubTypes.Type(value = StandardProduct.class, name = "STANDARD")
})
public sealed interface Product permits BasicProduct, DefaultProduct, StandardProduct {
    Long id();

    String name();

    String description();

    BigDecimal price();

    String type();

    BigDecimal getPrice();
}

