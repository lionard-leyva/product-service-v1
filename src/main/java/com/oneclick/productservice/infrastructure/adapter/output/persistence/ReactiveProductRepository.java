package com.oneclick.productservice.infrastructure.adapter.output.persistence;

import com.oneclick.productservice.domain.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveProductRepository extends ReactiveCrudRepository<Product, Long> {
}
