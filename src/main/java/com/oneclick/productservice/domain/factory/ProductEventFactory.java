package com.oneclick.productservice.domain.factory;

import com.oneclick.productservice.domain.Product;
import com.oneclick.productservice.domain.kafka.ProductEvent;


public interface ProductEventFactory {
    ProductEvent createProductEvent(Product product);
}

