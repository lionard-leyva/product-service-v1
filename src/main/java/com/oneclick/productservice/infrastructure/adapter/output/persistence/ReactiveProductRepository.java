package com.oneclick.productservice.infrastructure.adapter.output.persistence;

import com.oneclick.productservice.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {
}
