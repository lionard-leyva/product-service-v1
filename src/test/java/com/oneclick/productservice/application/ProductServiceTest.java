package com.oneclick.productservice.application;

import com.oneclick.productservice.application.ports.in.ProductServiceImpl;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductEntity;
import com.oneclick.productservice.dto.ProductMapper;
import com.oneclick.productservice.dto.ProductRequest;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import com.oneclick.productservice.testbuilders.ProductTestBuilder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Map;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {


    @InjectMocks
    public ProductServiceImpl productService;

    @Mock
    public ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    private record TestProduct(ProductRequest request, ProductEntity entity, ProductEntity savedEntity,
                               Product expected) {
    }

    private static final Map<String, TestProduct> testProducts = Map.of(
            "BASIC", new TestProduct(
                    ProductTestBuilder.basicProductRequest(),
                    ProductTestBuilder.basicProductEntity(),
                    ProductTestBuilder.savedBasicProductEntity(),
                    ProductTestBuilder.basicProduct()
            ),
            "STANDARD", new TestProduct(
                    ProductTestBuilder.standardProductRequest(),
                    ProductTestBuilder.standardProductEntity(),
                    ProductTestBuilder.savedStandardProductEntity(),
                    ProductTestBuilder.standardProduct()
            ),
            "DEFAULT", new TestProduct(
                    ProductTestBuilder.defaultProductRequest(),
                    ProductTestBuilder.defaultProductEntity(),
                    ProductTestBuilder.savedDefaultProductEntity(),
                    ProductTestBuilder.defaultProduct()
            )
    );

    private void setupMocksForProduct(String type) {
        TestProduct tp = testProducts.get(type);
        Mockito.when(productMapper.productRequestToEntity(tp.request)).thenReturn(tp.entity);
        Mockito.when(productRepository.save(tp.entity)).thenReturn(Mono.just(tp.savedEntity));
        Mockito.when(productMapper.productEntityToProduct(tp.savedEntity)).thenReturn(tp.expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"BASIC", "STANDARD", "DEFAULT"})
    void createProduct_shouldReturnCreatedProduct(String productType) {
        // Arrange
        TestProduct tp = testProducts.get(productType);
        setupMocksForProduct(productType);

        // Act
        Mono<Product> result = productService.createProduct(tp.request);

        // Assert
        StepVerifier.create(result)
                .expectNext(tp.expected)
                .verifyComplete();

        // Verify
        verify(productMapper).productRequestToEntity(tp.request);
        verify(productRepository).save(tp.entity);
        verify(productMapper).productEntityToProduct(tp.savedEntity);
    }
}