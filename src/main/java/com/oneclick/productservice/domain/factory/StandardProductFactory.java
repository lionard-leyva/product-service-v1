package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.StandardProduct;

import java.math.BigDecimal;

public class StandardProductFactory implements ProductFactory {
    @Override
    public Product create(Long id, String name, String description, BigDecimal price) {
        return new StandardProduct(id, name, description, price);
    }
}