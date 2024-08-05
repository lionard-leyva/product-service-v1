package com.oneclick.productservice.testbuilders;

public class ProductTestBuilder {

    @Builder
    public static Product product(Integer id, String name, String description, BigDecimal price, String type) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setType(type);
        return product;
    }

    public static ProductBuilder productBuilder() {
        return new ProductBuilder();
    }
}
