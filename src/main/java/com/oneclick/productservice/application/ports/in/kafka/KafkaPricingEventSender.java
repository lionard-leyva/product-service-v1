package com.oneclick.productservice.application.ports.in.kafka;

import com.oneclick.productservice.domain.kafka.ProductEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaPricingEventSender implements PricingEventSender {

    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public KafkaPricingEventSender(KafkaTemplate<String, ProductEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Mono<Void> sendPricingUpdateEvent(ProductEvent productEvent) {
        return Mono.fromFuture(() -> {
            CompletableFuture<SendResult<String, ProductEvent>> future = kafkaTemplate
                    .send("pricing.update", productEvent).toCompletableFuture();
            return future.thenApply(_ -> null);
        });
    }
}