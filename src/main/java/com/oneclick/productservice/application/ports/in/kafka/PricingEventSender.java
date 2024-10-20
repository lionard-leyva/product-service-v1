package com.oneclick.productservice.application.ports.in.kafka;

import com.oneclick.productservice.domain.kafka.ProductEvent;
import reactor.core.publisher.Mono;

public interface PricingEventSender {
  Mono<Void> sendPricingUpdateEvent(ProductEvent productEvent);
}