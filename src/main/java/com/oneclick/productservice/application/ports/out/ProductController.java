package com.oneclick.productservice.application.ports.out;

import com.oneclick.productservice.application.ports.in.ProductService;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.ProductData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<ResponseEntity<Product>> createProduct(@RequestBody ProductData data) {
        return service.createProduct(data)
                .map(product -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(product));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable String id,
                                                       @RequestBody ProductData data) {
        return service.updateProduct(id, data)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}