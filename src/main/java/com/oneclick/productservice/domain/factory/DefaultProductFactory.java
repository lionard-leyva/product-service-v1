package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.DefaultProduct;
import com.oneclick.productservice.domain.Product;

public class DefaultProductFactory implements ProductFactory {

    @Override
    public Product create(Long id, String name, String description, Double price) {
        return new DefaultProduct(id, name, description, price);
    }
}
