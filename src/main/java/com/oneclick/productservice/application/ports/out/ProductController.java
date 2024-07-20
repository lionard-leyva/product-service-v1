package com.oneclick.productservice.application.ports.out;

import com.oneclick.productservice.application.ports.in.ProductService;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.dto.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

//    @PutMapping("/{id}")
//    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable String id,
//                                                       @RequestBody ProductRequest productRequest) {
//        Product product = ProductRequestAdapter.toProduct(productRequest);
//        return productService.updateProduct(id, product)
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
}