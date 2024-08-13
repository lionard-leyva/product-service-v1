package com.oneclick.productservice.integration;

import com.oneclick.productservice.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ProductIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createProduct_shouldReturnCreatedProduct() {
        // Given
        ProductRequest productRequest = new ProductRequest("Monitor LCD", "Basic product", BigDecimal.TEN, "BASIC");

        // When
        webTestClient.post()
                .uri("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(productRequest)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Monitor LCD")
                .jsonPath("$.description").isEqualTo("Basic product")
                .jsonPath("$.price").isEqualTo(10);

    }
}
