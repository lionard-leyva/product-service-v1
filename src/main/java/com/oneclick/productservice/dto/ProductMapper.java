package com.oneclick.productservice.dto;

import com.oneclick.productservice.domain.*;
import com.oneclick.productservice.domain.strategy.PricingStrategy;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product productEntityToProduct(ProductEntity productEntity) {
        return switch (productEntity) {
            case ProductEntity(var id, var name, var description, var price, String type)
                    when type.equalsIgnoreCase("Basic") -> new BasicProduct(id, name, description, price, PricingStrategy.DEFAULT);
            case ProductEntity(var id, var name, var description, var price, String type)
                    when type.equalsIgnoreCase("Standard") -> new StandardProduct(id, name, description, price, PricingStrategy.DEFAULT);
            case ProductEntity(var id, var name, var description, var price, String type)
                    when type.equalsIgnoreCase("Default") -> new DefaultProduct(id, name, description, price, PricingStrategy.DEFAULT);

            default -> throw new IllegalArgumentException(STR."Unexpected value: \{productEntity}");
        };
    }
    public ProductEntity productToEntity(Product product) {
        return switch (product) {
            case BasicProduct basic -> new ProductEntity(basic.id(), basic.name(), basic.description(), basic.basePrice(), "Basic");
            case StandardProduct standard -> new ProductEntity(standard.id(), standard.name(), standard.description(), standard.basePrice(), "Standard");
            case DefaultProduct defaultProduct -> new ProductEntity(defaultProduct.id(), defaultProduct.name(), defaultProduct.description(), defaultProduct.basePrice(), "Default");
        };
    }
    public Product productRequestToProduct(ProductRequest request) {
        return switch (request) {
            case ProductRequest(var name, var description, var price, var type)
                    when type.equalsIgnoreCase("Basic") -> new BasicProduct(null, name, description, price, PricingStrategy.DEFAULT);
            case ProductRequest(var name, var description, var price, var type)
                    when type.equalsIgnoreCase("Standard") -> new StandardProduct(null, name, description, price, PricingStrategy.DEFAULT);
            case ProductRequest(var name, var description, var price, var type)
                    when type.equalsIgnoreCase("Default") -> new DefaultProduct(null, name, description, price, PricingStrategy.DEFAULT);
            default -> throw new IllegalArgumentException(STR."Unknown product type: \{request.type()}");
        };
    }
    public ProductEntity productRequestToEntity(ProductRequest request) {
        return new ProductEntity(
                null,
                request.name(),
                request.description(),
                request.price(),
                request.type().toLowerCase()
        );
    }

}

