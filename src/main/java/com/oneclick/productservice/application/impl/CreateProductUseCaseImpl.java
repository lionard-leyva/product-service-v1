package com.oneclick.productservice.application.impl;

import com.oneclick.productservice.application.impl.mapper.ProductRequestMapper;
import com.oneclick.productservice.domain.model.Product;
import com.oneclick.productservice.domain.port.input.CreateProductUseCase;
import com.oneclick.productservice.domain.port.output.ProductRepository;
import com.oneclick.productservice.infrastructure.adapter.input.rest.dto.CreateProductRequest;
import com.oneclick.productservice.infrastructure.adapter.output.mapper.ProductPersistenceMapper;
import reactor.core.publisher.Mono;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepository productRepository;
    private final ProductRequestMapper productRequestMapper;
    private final ProductPersistenceMapper productPersistenceMapper;

    public CreateProductUseCaseImpl(ProductRepository productRepository,
                                    ProductRequestMapper productRequestMapper,
                                    ProductPersistenceMapper productPersistenceMapper) {
        this.productRepository = productRepository;
        this.productRequestMapper = productRequestMapper;
        this.productPersistenceMapper = productPersistenceMapper;
    }


    @Override
    public Mono<Product> createProduct(CreateProductRequest productRequest) {
        return Mono.just(productRequest)
                .map(productRequestMapper::toDomain)
                .map(productPersistenceMapper::toEntity)
                .flatMap(productRepository::save);
    }
}
