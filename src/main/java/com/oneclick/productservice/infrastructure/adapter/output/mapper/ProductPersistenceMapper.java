package com.oneclick.productservice.infrastructure.adapter.output.mapper;

import com.oneclick.productservice.domain.model.*;
import com.oneclick.productservice.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPersistenceMapper {
    public ProductEntity toEntity(Product product) {
        return switch (product) {
            case BasicProduct(
                    String name,
                    String description,
                    BigDecimal basePrice,
                    BigDecimal finalPrice
            ) -> new ProductEntity(
                    null,  // id será generado
                    name,
                    description,
                    basePrice,
                    finalPrice,
                    ProductType.BASIC
            );
            case StandardProduct(
                    String name,
                    String description,
                    BigDecimal basePrice,
                    BigDecimal finalPrice
            ) -> new ProductEntity(
                    null,
                    name,
                    description,
                    basePrice,
                    finalPrice,
                    ProductType.STANDARD
            );
            case DefaultProduct(
                    String name,
                    String description,
                    BigDecimal basePrice,
                    BigDecimal finalPrice
            ) -> new ProductEntity(
                    null,
                    name,
                    description,
                    basePrice,
                    finalPrice,
                    ProductType.DEFAULT
            );
        };
    }

    public Product toDomain(ProductEntity entity) {
        return switch (entity) {
            case ProductEntity p -> switch (p.type()) {
                case BASIC -> new BasicProduct(
                        p.name(),
                        p.description(),
                        p.price(),
                        p.finalPrice()
                );
                case STANDARD -> new StandardProduct(
                        p.name(),
                        p.description(),
                        p.price(),
                        p.finalPrice()
                );
                case DEFAULT -> new DefaultProduct(
                        p.name(),
                        p.description(),
                        p.price(),
                        p.finalPrice()
                );
            };
        };
    }
}