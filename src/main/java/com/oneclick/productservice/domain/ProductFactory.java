package com.oneclick.productservice.domain;

public class ProductFactory {
    private ProductFactory() {
    }

    public static Product createProduct(ProductEntity entity) {
        return switch (entity.getType()) {
            case "Basic" ->
                    new BasicProduct(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
            case "Standard" ->
                    new StandardProduct(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
            default -> new DefaultProduct(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
        };
    }
}