package com.oneclick.productservice.testbuilders;

import com.oneclick.productservice.domain.*;
import com.oneclick.productservice.dto.ProductRequest;

import java.math.BigDecimal;

public class ProductTestBuilder {

    public static BasicProduct basicProduct() {
        return new BasicProduct(1L, "Basic Test Product", "Basic Description", BigDecimal.TEN, BigDecimal.valueOf(10));
    }

    public static StandardProduct standardProduct() {
        return new StandardProduct(2L, "Standard Test Product", "Standard Description", BigDecimal.valueOf(20), BigDecimal.valueOf(18));
    }

    public static DefaultProduct defaultProduct() {
        return new DefaultProduct(3L, "Default Test Product", "Default Description", BigDecimal.valueOf(15), BigDecimal.valueOf(13));
    }

    public static ProductRequest basicProductRequest() {
        return new ProductRequest("Basic Test Product", "Basic Description", BigDecimal.TEN, BigDecimal.ZERO, "BASIC");
    }

    public static ProductRequest standardProductRequest() {
        return new ProductRequest("Standard Test Product", "Standard Description", BigDecimal.TEN, BigDecimal.ZERO,"STANDARD");
    }

    public static ProductRequest defaultProductRequest() {
        return new ProductRequest("Default Test Product", "Default Description",BigDecimal.TEN, BigDecimal.ZERO, "DEFAULT");
    }

    public static ProductEntity basicProductEntity() {
        return new ProductEntity(1L, "Basic Test Product", "Basic Description", BigDecimal.TEN, BigDecimal.TEN, "BASIC");
    }

    public static ProductEntity standardProductEntity() {
        return new ProductEntity(2L, "Standard Test Product", "Standard Description", BigDecimal.valueOf(20), BigDecimal.valueOf(18), "STANDARD");
    }

    public static ProductEntity defaultProductEntity() {
        return new ProductEntity(3L, "Default Test Product", "Default Description", BigDecimal.valueOf(15), BigDecimal.valueOf(13), "DEFAULT");
    }

    public static ProductEntity savedBasicProductEntity() {
        return new ProductEntity(1L, "Basic Test Product", "Basic Description", BigDecimal.TEN, BigDecimal.valueOf(10), "BASIC");
    }

    public static ProductEntity savedStandardProductEntity() {
        return new ProductEntity(2L, "Standard Test Product", "Standard Description", BigDecimal.valueOf(20), BigDecimal.valueOf(18), "STANDARD");
    }

    public static ProductEntity savedDefaultProductEntity() {
        return new ProductEntity(3L, "Default Test Product", "Default Description", BigDecimal.valueOf(15), BigDecimal.valueOf(13), "DEFAULT");
    }

    public static class CustomProductBuilder {
        private Long id;
        private String name;
        private String description;
        private BigDecimal basePrice;
        private BigDecimal finalPrice;
        private String type;

        public CustomProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CustomProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CustomProductBuilder basePrice(BigDecimal basePrice) {
            this.basePrice = basePrice;
            return this;
        }

        public CustomProductBuilder finalPrice(BigDecimal finalPrice) {
            this.finalPrice = finalPrice;
            return this;
        }

        public CustomProductBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Product build() {
            return switch (type.toUpperCase()) {
                case "BASIC" -> new BasicProduct(id, name, description, basePrice, finalPrice);
                case "STANDARD" -> new StandardProduct(id, name, description, basePrice, finalPrice);
                case "DEFAULT" -> new DefaultProduct(id, name, description, basePrice, finalPrice);
                default -> throw new IllegalArgumentException("Unknown product type");
            };
        }

        public static CustomProductBuilder customProduct() {
            return new CustomProductBuilder();
        }
    }
}
