package com.oneclick.productservice.domain.port.output;

import com.oneclick.productservice.domain.model.Product;
import com.oneclick.productservice.infrastructure.entity.ProductEntity;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product> save(ProductEntity productEntity);
}
