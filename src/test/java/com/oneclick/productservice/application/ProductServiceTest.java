package com.oneclick.productservice.application;

import com.oneclick.productservice.application.ports.in.ProductServiceImpl;
import com.oneclick.productservice.domain.BasicProduct;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.dto.ProductMapper;
import com.oneclick.productservice.dto.ProductRequest;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    public ProductServiceImpl productService;

    @Mock
    public ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @Test
    void createProduct_shouldReturnCreatedProduct() {
        //Arrange
        ProductRequest productRequest = new ProductRequest("Test Product", "Test Description", BigDecimal.TEN, "BASIC");
        ProductEntity productEntity = new ProductEntity(1L, "Test Product", "Test Description", BigDecimal.TEN, "BASIC");
        ProductEntity savedProductEntity = new ProductEntity(1L, "Test Product", "Test Description", BigDecimal.TEN, "BASIC");
        Product createdProduct = new BasicProduct(1L, "Test Product", "Test Description", BigDecimal.TEN);

        //Act
        Mono<Product> result = productService.createProduct(productRequest);

        //Assert
        StepVerifier.create(result)
                .expectNext(createdProduct)
                .verifyComplete();
    }
}
