package com.oneclick.productservice.domain.strategy;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoDiscountStrategy.class, name = "NoDiscount"),
        @JsonSubTypes.Type(value = ChristmasDiscountStrategy.class, name = "Christmas"),
        @JsonSubTypes.Type(value = NoDiscountStrategy.class, name = "NoDiscount")
})
public interface PricingStrategy {
    PricingStrategy DEFAULT = new NoDiscountStrategy();
    BigDecimal calculatePrice(BigDecimal basePrice);
}
