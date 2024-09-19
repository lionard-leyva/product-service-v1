package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.dto.PricingResponse;
import org.springframework.kafka.annotation.KafkaListener;

public class PricingResponseListener {
    @KafkaListener(topics = "pricing.response", groupId = "pricing-group")
    public void listenPricingResponse(PricingResponse response) {
        System.out.println(STR."Received pricing response: \{response}");
    }
}