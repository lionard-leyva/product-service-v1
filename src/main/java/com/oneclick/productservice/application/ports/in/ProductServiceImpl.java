package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.*;
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
    public Mono<Product> createProduct(Product product) {
        return repository.save(mapToEntity(product)).map(this::mapToDomain);
    }

    @Override
    public Mono<Product> getProduct(String id) {
        return repository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Mono<Product> updateProduct(String id, Product product) {
        return repository.findById(id)
                .flatMap(existingProduct -> {
                    Product updatedProduct = createUpdatedProduct(product, existingProduct.getId());
                    return repository.save(mapToEntity(updatedProduct))
                            .map(this::mapToDomain);
                });
    }

    private Product createUpdatedProduct(Product product, Long existingId) {
        return switch (product) {
            case BasicProduct basicProduct ->
                    new BasicProduct(existingId, basicProduct.name(), basicProduct.description(), basicProduct.price());
            case StandardProduct standardProduct ->
                    new StandardProduct(existingId, standardProduct.name(), standardProduct.description(), standardProduct.price());
            case DefaultProduct defaultProduct ->
                    new DefaultProduct(existingId, defaultProduct.name(), defaultProduct.description(), defaultProduct.price());

        };
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