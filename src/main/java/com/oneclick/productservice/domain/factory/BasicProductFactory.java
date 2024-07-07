package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.BasicProduct;
import com.oneclick.productservice.domain.Product;

public class BasicProductFactory implements ProductFactory {
    @Override
    public Product create(Long id, String name, String description, Double price) {
        return new BasicProduct(id, name, description, price);
    }
}