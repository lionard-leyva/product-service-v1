package com.oneclick.productservice.application.impl;

import com.oneclick.productservice.application.impl.mapper.ProductRequestMapper;
import com.oneclick.productservice.domain.model.Product;
import com.oneclick.productservice.domain.port.input.CreateProductUseCase;
import com.oneclick.productservice.domain.port.output.ProductRepository;
import com.oneclick.productservice.infrastructure.adapter.input.rest.dto.CreateProductRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepository productRepository;
    private final ProductRequestMapper productRequestMapper;


    public CreateProductUseCaseImpl(ProductRepository productRepository,
                                    ProductRequestMapper productRequestMapper) {
        this.productRepository = productRepository;
        this.productRequestMapper = productRequestMapper;
    }

    @Override
    public Mono<Product> createProduct(CreateProductRequest productRequest) {
        return Mono.just(productRequest)
                .map(productRequestMapper::toDomain)
                .flatMap(productRepository::save);
    }
}