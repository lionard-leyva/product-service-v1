package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.Product;

public interface ProductFactory {

    Product create(Long id, String name, String description, Double price);
}