package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.Product;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> createProduct(Product data);

    Mono<Product> getProduct(String id);

    Mono<Product> updateProduct(String id, Product data);

    Mono<Void> deleteProduct(String id);
}