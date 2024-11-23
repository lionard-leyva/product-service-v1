package com.oneclick.productservice.domain.port.input;


import com.oneclick.productservice.domain.model.Product;
import com.oneclick.productservice.infrastructure.adapter.input.rest.dto.CreateProductRequest;
import reactor.core.publisher.Mono;

public interface CreateProductUseCase {
    Mono<Product> createProduct(CreateProductRequest productRequest);
}