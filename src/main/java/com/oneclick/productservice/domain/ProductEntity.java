package com.oneclick.productservice.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("productdb.product")
public record ProductEntity(
        @Id Long id,
        @NotNull String name,
        String description,
        @NotNull BigDecimal price,
        BigDecimal finalPrice,
        @NotNull String type
) {
    public ProductEntity withFinalPrice(BigDecimal finalPrice) {
        return new ProductEntity(id, name, description, price, finalPrice, type);
    }
}