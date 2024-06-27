package com.oneclick.productservice.infraestructure.persistence;

import com.oneclick.productservice.domain.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, String> {
}
