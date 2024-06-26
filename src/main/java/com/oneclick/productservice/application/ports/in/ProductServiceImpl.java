package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.domain.ProductFactory;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Product> createProduct(Product data) {
        return repository.save(mapToEntity(data)).map(this::mapToDomain);
    }

    @Override
    public Mono<Product> getProduct(String id) {
        return repository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Mono<Product> updateProduct(String id, Product data) {
        return repository.findById(id)
                .map(product -> mapToEntity(data))
                .flatMap(repository::save)
                .map(this::mapToDomain);
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        return repository.deleteById(id);
    }

    public Product mapToDomain(ProductEntity entity) {
        return ProductFactory.createProduct(entity);
    }

    private ProductEntity mapToEntity(Product product) {
        return productToEntityConverter.apply(product);
    }

    private final Function<Product, ProductEntity> productToEntityConverter = product -> {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.id());
        entity.setName(product.name());
        entity.setDescription(product.description());
        entity.setPrice(product.price());
        entity.setType(product.type());
        return entity;
    };
}