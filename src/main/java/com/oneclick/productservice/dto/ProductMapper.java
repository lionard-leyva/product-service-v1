package com.oneclick.productservice.dto;

import com.oneclick.productservice.domain.*;

public class ProductMapper {

    public Product productEntityToProduct (ProductEntity productEntity) {
        return switch (productEntity) {
            case ProductEntity(var id, var name, var description, var price, String type)
                    when type.equalsIgnoreCase("Basic") -> new BasicProduct(id, name, description, price);
            case ProductEntity(var id, var name, var description, var price, String type)
                    when type.equalsIgnoreCase("Standard") -> new StandardProduct(id, name, description, price);
            case ProductEntity(var id, var name, var description, var price, String type)
                    when type.equalsIgnoreCase("Default") -> new DefaultProduct(id, name, description, price);

            default -> throw new IllegalArgumentException("Unexpected value: " + productEntity);
        };
    }
}

