package com.oneclick.productservice.application.impl.mapper;

import com.oneclick.productservice.domain.model.BasicProduct;
import com.oneclick.productservice.domain.model.DefaultProduct;
import com.oneclick.productservice.domain.model.Product;
import com.oneclick.productservice.domain.model.StandardProduct;
import com.oneclick.productservice.infrastructure.adapter.input.rest.dto.CreateProductRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductRequestMapper {
    public Product toDomain(CreateProductRequest request) {
        request.validate();
        return switch (request) {
            case CreateProductRequest
                         .CreateBasicProductRequest(
                    String name,
                    String description,
                    BigDecimal basePrice
            ) -> new BasicProduct(
                    name,
                    description,
                    basePrice,
                    null  // finalPrice inicialmente null
            );
            case CreateProductRequest
                         .CreateStandardProductRequest(
                    String name,
                    String description,
                    BigDecimal basePrice
            ) -> new StandardProduct(
                    name,
                    description,
                    basePrice,
                    null
            );
            case CreateProductRequest
                         .CreateDefaultProductRequest(
                    String name,
                    String description,
                    BigDecimal basePrice

            ) -> new DefaultProduct(
                    name,
                    description,
                    basePrice,
                    null
            );
        };
    }
}