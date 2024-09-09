package com.oneclick.productservice.application.ports.out;

import com.oneclick.productservice.application.ports.in.ProductService;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.dto.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Mono<ResponseEntity<Product>> createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest)
                .map(product -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(product));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable String id) {
        return productService.getProduct(Long.valueOf(id))
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable String id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(Long.valueOf(id), productRequest)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(Long.valueOf(id))
                .map(ResponseEntity::ok);
    }
}