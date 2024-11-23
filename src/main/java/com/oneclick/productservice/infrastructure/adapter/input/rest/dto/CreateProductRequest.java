package com.oneclick.productservice.infrastructure.adapter.input.rest.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oneclick.productservice.domain.model.ProductType;

import java.math.BigDecimal;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateProductRequest.CreateBasicProductRequest.class, name = "BASIC"),
        @JsonSubTypes.Type(value = CreateProductRequest.CreateStandardProductRequest.class, name = "STANDARD"),
        @JsonSubTypes.Type(value = CreateProductRequest.CreateDefaultProductRequest.class, name = "DEFAULT")
})
public sealed interface CreateProductRequest
        permits
        CreateProductRequest.CreateBasicProductRequest,
        CreateProductRequest.CreateDefaultProductRequest,
        CreateProductRequest.CreateStandardProductRequest {

    String name();

    String description();

    BigDecimal basePrice();

    ProductType type();

    default void validate() {
        if (name() == null || name().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (basePrice() == null || basePrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Base price cannot be null or less than zero");
        }
    }


    @JsonTypeName("BASIC")
    record CreateBasicProductRequest(
            String name,
            String description,
            BigDecimal basePrice
    ) implements CreateProductRequest {
        @Override
        public ProductType type() {
            return ProductType.BASIC;
        }
    }

    @JsonTypeName("STANDARD")
    record CreateStandardProductRequest(
            String name,
            String description,
            BigDecimal basePrice
    ) implements CreateProductRequest {
        @Override
        public ProductType type() {
            return ProductType.STANDARD;
        }
    }

    @JsonTypeName("DEFAULT")
    record CreateDefaultProductRequest(
            String name,
            String description,
            BigDecimal basePrice
    ) implements CreateProductRequest {
        @Override
        public ProductType type() {
            return ProductType.DEFAULT;
        }
    }
}