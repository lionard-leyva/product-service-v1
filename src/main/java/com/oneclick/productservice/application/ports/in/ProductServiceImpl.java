package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.domain.factory.ProductFactoryProvider;
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
        return repository.save(mapProductToProductEntity(product)).map(this::mapToDomain);
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
                    return repository.save(mapProductToProductEntity(updatedProduct))
                            .map(this::mapToDomain);
                });
    }

    private Product createUpdatedProduct(Product product, Long existingId) {
        var factory = ProductFactoryProvider.getFactory(product);
        return factory.create(existingId, product.name(), product.description(), product.price());
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        return repository.deleteById(id);
    }

    public Product mapToDomain(ProductEntity entity) {
        var factory = ProductFactoryProvider.getFactory(productEntityToProduct(entity));
        return factory.create(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
    }

    private Product productEntityToProduct(ProductEntity entity) {
        var factory = ProductFactoryProvider.getFactory(entity.getType());
        return factory.create(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
    }

    private ProductEntity mapProductToProductEntity(Product product) {
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