package com.oneclick.productservice.application.ports.in.kafka;

import com.oneclick.productservice.domain.kafka.ProductEvent;

public interface PricingEventSender {
  void sendPricingUpdateEvent(ProductEvent productEvent);
}