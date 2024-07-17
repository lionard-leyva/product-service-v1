package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.Product;

import java.math.BigDecimal;

public interface ProductFactory {

    Product create(Long id, String name, String description, BigDecimal price);
}