package com.oneclick.productservice.domain.kafka;

import java.math.BigDecimal;

public record PriceCalculatedEvent(
    Long productId,
    BigDecimal finalPrice
) {}