package com.oneclick.productservice.domain.kafka;

import java.math.BigDecimal;

public record ProductEvent(Long productId,
                           String name,
                           BigDecimal price,
                           String type) {
}
