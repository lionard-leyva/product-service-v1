package com.oneclick.productservice.application;

import com.oneclick.productservice.domain.*;
import com.oneclick.productservice.dto.ProductMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {
    private final ProductMapper productMapper = new ProductMapper();

    @Test
    void mapToDomain_withBasicProduct_shouldReturnBasicProduct() {
        ProductEntity productEntity = new ProductEntity(1L, "Basic Product", "Description", BigDecimal.valueOf(10.00), "BASIC");
        Product result = productMapper.mapToDomain(productEntity);
        assertInstanceOf(BasicProduct.class, result);
    }

    @Test
    void mapToDomain_withDefaultProduct_shouldReturnDefaultProduct() {
        ProductEntity productEntity = new ProductEntity(1L, "Default Product", "Description", BigDecimal.valueOf(10.00), "DEFAULT");
        Product result = productMapper.mapToDomain(productEntity);
        assertInstanceOf(DefaultProduct.class, result);
    }

    @Test
    void mapToDomain_withStandardProduct_shouldReturnDefaultProduct() {
        ProductEntity productEntity = new ProductEntity(1L, "Standard Product", "Description", BigDecimal.valueOf(10.00), "STANDARD");
        Product result = productMapper.mapToDomain(productEntity);
        assertInstanceOf(StandardProduct.class, result);
    }

    @Test
    void mapToDomain_withUnknownProduct_shouldReturnDefaultProduct() {
        ProductEntity productEntity = new ProductEntity(1L, "Unknown Product", "Description", BigDecimal.valueOf(10.00), "UNKNOWN");
       assertThrows(IllegalArgumentException.class, () -> productMapper.mapToDomain(productEntity));
    }
}