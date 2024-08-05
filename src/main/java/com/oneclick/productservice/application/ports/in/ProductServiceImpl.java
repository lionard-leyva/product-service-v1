package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.domain.factory.ProductFactoryRegistry;
import com.oneclick.productservice.dto.ProductRequest;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductFactoryRegistry factoryRegistry;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductFactoryRegistry factoryRegistry) {
        this.productRepository = productRepository;
        this.factoryRegistry = factoryRegistry;
    }

    @Override
    public Mono<Product> createProduct(ProductRequest productRequest) {
//        return Mono.just(productRequest)
//                .map(this::createProductFromRequest)
//                .flatMap(productRepository::save)
//                .map(this::mapToDomain);
        return null;
    }

    private Product createProductFromRequest(ProductRequest request) {
        return switch (request) {
            case ProductRequest(var name, var description, var price, var type)
                    when factoryRegistry.getFactory(type) != null ->
                    factoryRegistry.getFactory(type).create(null, name, description, price);
            case ProductRequest(_, _, _, var type) ->
                    throw new IllegalArgumentException("Unknown product type: " + type);
        };
    }

    @Override
    public Mono<Product> getProduct(String id) {
        return productRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Mono<Product> updateProduct(String id, Product product) {
        //TODO: Implement this method
//        return repository.findById(id)
//                .flatMap(existingProduct -> {
//                    Product updatedProduct = createUpdatedProduct(product, existingProduct.getId());
//                    return repository.save(mapToEntity(updatedProduct))
//                            .map(this::mapToDomain);
//                });
        return null;
    }

    private Product createUpdatedProduct(Product product, Long existingId) {
//        var factory = ProductFactoryRegistry.getFactory(product);
//        return factory.create(existingId, product.name(), product.description(), product.price());
        return null;
    }


    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }

    @Override
    public Flux<Product> getAllProduct() {
        return null;
    }

    public Product mapToDomain(ProductEntity entity) {

        return null;
    }

//    private ProductEntity mapToEntity(Product product) {
//        return productToEntityConverter.apply(product);
//    }

//    private final Function<Product, ProductEntity> productToEntityConverter = product -> {
//        ProductEntity entity = new ProductEntity();
//        entity.setId(product.id());
//        entity.setName(product.name());
//        entity.setDescription(product.description());
//        entity.setPrice(product.price());
//        entity.setType(product.type());
//        return entity;
//    };
}