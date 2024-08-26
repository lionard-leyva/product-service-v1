package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.dto.ProductRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> createProduct(ProductRequest productRequest);

    Mono<Product> getProduct(Long id);

    Mono<Product> updateProduct(Long id, ProductRequest productRequest);

    Mono<Void> deleteProduct(Long id);

    Flux<Product> getAllProduct();
}