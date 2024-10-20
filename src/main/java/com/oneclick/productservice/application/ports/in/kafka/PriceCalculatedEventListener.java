package com.oneclick.productservice.application.ports.in.kafka;

import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.domain.kafka.PriceCalculatedEvent;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculatedEventListener {

    private final ProductRepository productRepository;
    private final Logger logger = LoggerFactory.getLogger(PriceCalculatedEventListener.class);

    public PriceCalculatedEventListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @KafkaListener(topics = "pricing-calculated")
    public void handlePriceCalculatedEvent(PriceCalculatedEvent event) {
        System.out.println(STR."Received price calculated event: \{event}");
        logger.info("Received price calculated event: {}", event);
        productRepository.findById(event.productId())
                .flatMap(productEntity -> {
                    ProductEntity productEntityWithPrice = productEntity.withFinalPrice(event.finalPrice());
                    return productRepository.save(productEntityWithPrice);
                }).subscribe();
    }
}