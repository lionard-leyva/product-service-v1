//package com.oneclick.productservice.application.ports.out;
//
//import com.oneclick.productservice.adapter.ProductRequestAdapter;
//import com.oneclick.productservice.application.ports.in.ProductService;
//import com.oneclick.productservice.domain.Product;
//import com.oneclick.productservice.dto.ProductRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//
//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @PostMapping
//    public Mono<ResponseEntity<Product>> createProduct(@RequestBody ProductRequest productRequest) {
//        Product product = ProductRequestAdapter.toProduct(productRequest);
//        return productService.createProduct(product)
//                .map(ResponseEntity::ok);
//    }
//
//    @PutMapping("/{id}")
//    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable String id,
//                                                       @RequestBody ProductRequest productRequest) {
//        Product product = ProductRequestAdapter.toProduct(productRequest);
//        return productService.updateProduct(id, product)
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
//}