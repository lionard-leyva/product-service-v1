package com.oneclick.productservice.controller;

import com.oneclick.productservice.application.ports.in.ProductService;
import com.oneclick.productservice.application.ports.out.ProductController;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.dto.ProductRequest;
import com.oneclick.productservice.infraestructure.persistence.ProductRepository;
import com.oneclick.productservice.testbuilders.ProductTestBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

import static java.lang.StringTemplate.STR;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = ProductController.class)
class ProductControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    private record TestCase(String type, ProductRequest productRequest, Product expectedProduct) {
    }

    private static Stream<TestCase> productTestCases() {
        return Stream.of(
                new TestCase("BASIC", ProductTestBuilder.basicProductRequest(), ProductTestBuilder.basicProduct()),
                new TestCase("STANDARD", ProductTestBuilder.standardProductRequest(), ProductTestBuilder.standardProduct()),
                new TestCase("DEFAULT", ProductTestBuilder.defaultProductRequest(), ProductTestBuilder.defaultProduct())
        );
    }

    @ParameterizedTest
    @MethodSource("productTestCases")
    void createProduct_shouldReturnCreatedProduct(TestCase testCase) {
        when(productService.createProduct(testCase.productRequest)).thenReturn(Mono.just(testCase.expectedProduct));

        webTestClient.post()
                .uri("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(testCase.productRequest)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Product.class)
                .isEqualTo(testCase.expectedProduct);
        verify(productService).createProduct(testCase.productRequest);
    }
    @ParameterizedTest
    @MethodSource("productTestCases")
    void getProduct_shouldReturnProduct(TestCase testCase) {
        when(productService.getProduct(testCase.expectedProduct.id())).thenReturn(Mono.just(testCase.expectedProduct));

        webTestClient.get()
                .uri(STR."/api/products/\{testCase.expectedProduct.id()}")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Product.class)
                .isEqualTo(testCase.expectedProduct);
        verify(productService).getProduct(testCase.expectedProduct.id());
    }

    @ParameterizedTest
    @MethodSource("productTestCases")
    void updateProduct_shouldReturnUpdatedProduct(TestCase testCase) {
        when(productService.updateProduct(testCase.expectedProduct.id(), testCase.productRequest)).thenReturn(Mono.just(testCase.expectedProduct));

        webTestClient.put()
                .uri(STR."/api/products/\{testCase.expectedProduct.id()}")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(testCase.productRequest)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Product.class)
                .isEqualTo(testCase.expectedProduct);
        verify(productService).updateProduct(testCase.expectedProduct.id(), testCase.productRequest);
    }
}
