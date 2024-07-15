package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.BasicProduct;
import com.oneclick.productservice.domain.DefaultProduct;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.StandardProduct;

public class ProductFactoryProvider {
    private ProductFactoryProvider() {
    }

    public static ProductFactory getFactory(Product product) {
        return switch (product) {
            case BasicProduct basicProduct -> new BasicProductFactory();
            case StandardProduct standardProduct -> new StandardProductFactory();
            case DefaultProduct defaultProduct -> new DefaultProductFactory();
        };
    }
}