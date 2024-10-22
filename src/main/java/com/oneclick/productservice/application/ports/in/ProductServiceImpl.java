package com.oneclick.productservice.application.ports.in;

import com.oneclick.productservice.application.ports.in.kafka.PricingEventSender;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.domain.factory.ProductEventFactory;
import com.oneclick.productservice.domain.kafka.ProductEvent;
import com.oneclick.productservice.dto.ProductMapper;
import com.oneclick.productservice.dto.ProductRequest;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final PricingEventSender kafkaPricingEventSender;
    private final ProductEventFactory productEventFactory;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              PricingEventSender kafkaPricingEventSender,
                              ProductEventFactory productEventFactory) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.kafkaPricingEventSender = kafkaPricingEventSender;
        this.productEventFactory = productEventFactory;
    }

    @Override
    public Mono<Product> createProduct(ProductRequest productRequest) {
        return Mono.just(productRequest)
                .map(productMapper::productRequestToProduct)
                .flatMap(product -> {
                    ProductEntity productEntity = productMapper.productToEntity(product).withFinalPrice(BigDecimal.ZERO);
                    return productRepository.save(productEntity);
                })
                .flatMap(savedProductEntity -> {
                    Product savedProduct = productMapper.productEntityToProduct(savedProductEntity);
                    ProductEvent productEvent = productEventFactory.createProductEvent((savedProduct));
                    return kafkaPricingEventSender.sendPricingUpdateEvent(productEvent)
                            .thenReturn(savedProduct);
                })
                .doOnNext(product -> log.info("Product creado y event enviado a Kafka para el producto ID: {}", product.id()));
    }

    @Override
    public Mono<Product> updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.findById(id)
                .flatMap(existingProductEntity -> {
                    Product existingProduct = productMapper.productEntityToProduct(existingProductEntity);
                    Product updatedProduct = productMapper.updateProductFromRequest(existingProduct, productRequest);
                    //Set finalPrice to zero before to save
                    ProductEntity updatedProductEntity = productMapper.productToEntity(updatedProduct).withFinalPrice(BigDecimal.ZERO);
                    return productRepository.save(updatedProductEntity)
                            .flatMap(savedProductEntity -> {
                                //create ProductEvent and send to kafka
                                Product savedProduct = productMapper.productEntityToProduct(savedProductEntity);
                                ProductEvent savedProductEvent = productEventFactory.createProductEvent(savedProduct);
                                return kafkaPricingEventSender.sendPricingUpdateEvent(savedProductEvent)
                                        .thenReturn(savedProduct);

                            });
                })
                .doOnNext(product -> log.info("Producto actualizado y evento enviado a Kafka para el producto ID: {}", product.id()));
    }

    @Override
    public Mono<Product> getProduct(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productEntityToProduct)
                .doOnNext(product -> log.info("Product found: {}", product.id()));
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