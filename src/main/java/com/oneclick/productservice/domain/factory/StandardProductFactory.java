package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.StandardProduct;

public class StandardProductFactory implements ProductFactory {
    @Override
    public Product create(Long id, String name, String description, Double price) {
        return new StandardProduct(id, name, description, price);
    }
}