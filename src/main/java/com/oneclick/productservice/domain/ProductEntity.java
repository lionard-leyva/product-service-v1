package com.oneclick.productservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("product")
public record ProductEntity(@Id Long id, String name, String description, BigDecimal price, String type) {
}
