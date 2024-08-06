package com.oneclick.productservice.application;

import com.oneclick.productservice.application.ports.in.ProductServiceImpl;
import com.oneclick.productservice.domain.BasicProduct;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.dto.ProductMapper;
import com.oneclick.productservice.dto.ProductRequest;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import com.oneclick.productservice.testbuilders.ProductTestBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

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
        // Arrange
        ProductRequest productRequest = ProductTestBuilder.basicProductRequest();
        Product expectedProduct = ProductTestBuilder.basicProduct();
        ProductEntity productEntity = new ProductEntity(null, "Basic Test Product", "Basic Description", BigDecimal.TEN, "BASIC");
        ProductEntity savedProductEntity = new ProductEntity(1L, "Basic Test Product", "Basic Description", BigDecimal.TEN, "BASIC");

        // Configurar los mocks
        Mockito.when(productMapper.productRequestToEntity(productRequest)).thenReturn(productEntity);
        Mockito.when(productRepository.save(productEntity)).thenReturn(Mono.just(savedProductEntity));
        Mockito.when(productMapper.productEntityToProduct(savedProductEntity)).thenReturn(expectedProduct);

        // Act
        Mono<Product> result = productService.createProduct(productRequest);

        // Assert
        StepVerifier.create(result)
                .expectNext(expectedProduct)
                .verifyComplete();

        // Verify
        verify(productMapper).productRequestToEntity(productRequest);
        verify(productRepository).save(productEntity);
        verify(productMapper).productEntityToProduct(savedProductEntity);
    }
}
