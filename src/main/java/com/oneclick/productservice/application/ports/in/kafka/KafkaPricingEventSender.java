package com.oneclick.productservice.application.ports.in.kafka;

import com.oneclick.productservice.domain.kafka.ProductEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPricingEventSender implements PricingEventSender {

    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public KafkaPricingEventSender(KafkaTemplate<String, ProductEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendPricingUpdateEvent(ProductEvent productEvent) {
        kafkaTemplate.send("pricing.update", productEvent);
    }
}