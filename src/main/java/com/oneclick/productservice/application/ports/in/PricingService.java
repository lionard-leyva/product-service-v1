package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.Pricing;
import com.oneclick.productservice.domain.Product;
import reactor.core.publisher.Mono;

public interface PricingService {
    Mono<Pricing> updatePricing(Product product);

}
