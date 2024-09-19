package com.oneclick.productservice.dto;

import com.oneclick.productservice.domain.*;
import com.oneclick.productservice.domain.strategy.PricingStrategy;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product productEntityToProduct(ProductEntity productEntity) {
        return switch (productEntity) {
            case ProductEntity(var id, var name, var description, var price, var finalPrice, String type)
                    when type.equalsIgnoreCase("Basic") -> new BasicProduct(id, name, description, price, finalPrice);
            case ProductEntity(var id, var name, var description, var price, var finalPrice, String type)
                    when type.equalsIgnoreCase("Standard") ->
                    new StandardProduct(id, name, description, price, finalPrice);
            case ProductEntity(var id, var name, var description, var price, var finalPrice, String type)
                    when type.equalsIgnoreCase("Default") ->
                    new DefaultProduct(id, name, description, price, finalPrice);

            default -> throw new IllegalArgumentException(STR."Unexpected value: \{productEntity}");
        };
    }

    public ProductEntity productToEntity(Product product) {
        return switch (product) {
            case BasicProduct basic ->
                    new ProductEntity(basic.id(), basic.name(), basic.description(), basic.basePrice(), basic.finalPrice(), "Basic");
            case StandardProduct standard ->
                    new ProductEntity(standard.id(), standard.name(), standard.description(), standard.basePrice(), standard.finalPrice(), "Standard");
            case DefaultProduct defaultProduct ->
                    new ProductEntity(defaultProduct.id(), defaultProduct.name(), defaultProduct.description(), defaultProduct.basePrice(), defaultProduct.finalPrice(), "Default");
        };
    }

    public Product productRequestToProduct(ProductRequest request) {
        return switch (request.type().toLowerCase()) {
            case "basic" ->
                    new BasicProduct(null, request.name(), request.description(), request.basePrice(), request.finalPrice());
            case "standard" ->
                    new StandardProduct(null, request.name(), request.description(), request.basePrice(), request.finalPrice());
            case "default" ->
                    new DefaultProduct(null, request.name(), request.description(), request.basePrice(), request.finalPrice());
            default ->
                    throw new IllegalArgumentException(STR."Unknown product type: \{request.type()}");
        };
    }


    public ProductEntity productRequestToEntity(ProductRequest request) {
        return new ProductEntity(
                null,
                request.name(),
                request.description(),
                request.basePrice(),
                request.finalPrice(),
                request.type().toLowerCase()
        );
    }


}

