package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.Product;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> createProduct(Product productRequest);

    Mono<Product> getProduct(String id);

    Mono<Product> updateProduct(String id, Product productRequest);

    Mono<Void> deleteProduct(String id);
}