package com.oneclick.productservice.infrastructure.adapter.output.persistence;

import com.oneclick.productservice.domain.model.Product;
import com.oneclick.productservice.domain.port.output.ProductRepository;
import com.oneclick.productservice.infrastructure.adapter.output.mapper.ProductPersistenceMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ReactiveProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    public ProductRepositoryImpl(ReactiveProductRepository productRepository,
                                 ProductPersistenceMapper productPersistenceMapper) {
        this.productRepository = productRepository;
        this.productPersistenceMapper = productPersistenceMapper;
    }

    @Override
    public Mono<Product> save(Product product) {
        return Mono.just(product)
                .map(productPersistenceMapper::toEntity)
                .flatMap(productRepository::save)
                .map(productPersistenceMapper::toDomain);
    }
}