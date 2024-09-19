package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.Pricing;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.dto.PricingResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class KafkaPricingService implements PricingService {

    private final KafkaTemplate<String, Product> kafkaTemplate;

    public KafkaPricingService(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Mono<Pricing> updatePricing(Product product) {
        return Mono.fromCallable(() -> {
            kafkaTemplate.send("pricing.update", product);
            return new Pricing(product.id(), product.getPrice());
        });
    }

    @KafkaListener(id = "pricing.response", topics = "pricing-group")
    public void listenPricingResponse(PricingResponse response) {
        System.out.println(STR."Received pricing response: \{response}");
    }
}
