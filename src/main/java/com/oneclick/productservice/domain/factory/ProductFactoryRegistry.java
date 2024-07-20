package com.oneclick.productservice.domain.factory;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ProductFactoryRegistry {

    private final Map<String, ProductFactory> factories;

    public ProductFactoryRegistry() {
        factories = new HashMap<>();
        factories.put("basic", new BasicProductFactory());
        factories.put("default", new DefaultProductFactory());
        factories.put("standard", new StandardProductFactory());
    }

    public ProductFactory getFactory(String type) {
        return factories.get(type.toLowerCase());
    }
}