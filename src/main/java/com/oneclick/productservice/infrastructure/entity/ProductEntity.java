package com.oneclick.productservice.infrastructure.entity;


import com.oneclick.productservice.domain.model.ProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "product", schema = "productdb")
public record ProductEntity(
        @Column("id")
        @Id Long id,
        @Column("name")
        @NotNull String name,
        @Column("description")
        String description,
        @Column("price")
        @NotNull BigDecimal price,
        @Column("final_price")
        BigDecimal finalPrice,
        @Column("type")
        @Enumerated(EnumType.STRING) ProductType type
) {
    public ProductEntity withFinalPrice(BigDecimal finalPrice) {
        return new ProductEntity(id, name, description, price, finalPrice, type);
    }
}