package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.BasicProduct;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.kafka.ProductEvent;
import com.oneclick.productservice.domain.StandardProduct;
import com.oneclick.productservice.domain.DefaultProduct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DefaultProductEventFactory implements ProductEventFactory {

    @Override
    public ProductEvent createProductEvent(Product product) {
        return switch (product) {
            case BasicProduct(Long id, String name, _, BigDecimal price, _) ->
                    new ProductEvent(id, name, price, product.type());
            case StandardProduct(Long id, String name, _, BigDecimal price, _) ->
                    new ProductEvent(id, name, price, product.type());
            case DefaultProduct(Long id, String name, _, BigDecimal price, _) ->
                    new ProductEvent(id, name, price, product.type());
        };
    }
}