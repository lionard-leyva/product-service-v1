package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.domain.*;
import com.oneclick.productservice.domain.factory.ProductFactoryRegistry;
import com.oneclick.productservice.dto.ProductMapper;
import com.oneclick.productservice.dto.ProductRequest;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ProductFactoryRegistry factoryRegistry;
    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductRepository productRepository,
                              ProductFactoryRegistry factoryRegistry,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.factoryRegistry = factoryRegistry;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<Product> createProduct(ProductRequest productRequest) {
        return Mono.just(productRequest)
                .map(productMapper::productRequestToEntity)
                .flatMap(productRepository::save)
                .map(productMapper::productEntityToProduct)
                .doOnNext(savedProduct -> log.info("Product created: {}", savedProduct.id()));
    }

    @Override
    public Mono<Product> getProduct(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productEntityToProduct)
                .doOnNext(product -> log.info("Product found: {}", product.id()));
    }

    @Override
    public Mono<Product> updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    Product updatedProduct = productMapper.productRequestToProduct(productRequest);
                    Product product = switch (updatedProduct) {
                        case BasicProduct basic ->
                                new BasicProduct(existingProduct.id(), basic.name(), basic.description(), basic.price());
                        case DefaultProduct defaultProd ->
                                new DefaultProduct(existingProduct.id(), defaultProd.name(), defaultProd.description(), defaultProd.price());
                        case StandardProduct standard ->
                                new StandardProduct(existingProduct.id(), standard.name(), standard.description(), standard.price());
                    };
                    ProductEntity productEntity = productMapper.productToEntity(product);
                    return productRepository.save(productEntity)
                            .map(productMapper::productEntityToProduct);
                });
    }

    @Override
    public Mono<Void> deleteProduct(Long id) {
        return null;
    }

    @Override
    public Flux<Product> getAllProduct() {
        return null;
    }
}
