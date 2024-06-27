package com.oneclick.productservice.adapter;

import com.oneclick.productservice.domain.BasicProduct;
import com.oneclick.productservice.domain.DefaultProduct;
import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.StandardProduct;
import com.oneclick.productservice.dto.ProductRequest;

public class ProductRequestAdapter {
    private ProductRequestAdapter() {
    }

    public static Product toProduct(ProductRequest productRequest) {
        return switch (productRequest.getType()) {
            case "Basic" ->
                    new BasicProduct(0L, productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());
            case "Standard" ->
                    new StandardProduct(0L, productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());
            default ->
                    new DefaultProduct(0L, productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());
        };
    }
}
