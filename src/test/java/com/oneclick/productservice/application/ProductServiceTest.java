package com.oneclick.productservice.application;

import com.oneclick.productservice.application.ports.in.ProductServiceImpl;
import com.oneclick.productservice.domain.BasicProduct;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import static org.mockito.ArgumentMatchers.any;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;


    @Mock
    private ModelMapper mapper;


    @Test
    void CreateProduct_Basic() {
        // Arrange
        Product product = new BasicProduct(1L, "Basic Product", "Description", 100.0);
        ProductEntity productEntity = new ProductEntity(1L, "Basic Product", "Description", 100.0, "Basic");
        Mockito.when(productRepository.save(any(ProductEntity.class))).thenReturn(Mono.just(productEntity));

        Mono<Product> result = productService.createProduct(product);

        // Assert
        StepVerifier.create(result)
                .expectNextMatches(createdProduct -> createdProduct.name().equals("Basic Product"))
                .verifyComplete();
    }

}
