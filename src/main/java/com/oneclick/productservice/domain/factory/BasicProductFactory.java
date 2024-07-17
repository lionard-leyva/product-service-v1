package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.BasicProduct;
import com.oneclick.productservice.domain.Product;

import java.math.BigDecimal;

public class BasicProductFactory implements ProductFactory {
    @Override
    public Product create(Long id, String name, String description, BigDecimal price) {
        return new BasicProduct(id, name, description, price);
    }
}