package com.oneclick.productservice.testbuilders;

import com.oneclick.productservice.domain.*;
import com.oneclick.productservice.domain.strategy.PricingStrategy;
import com.oneclick.productservice.dto.ProductRequest;

import java.math.BigDecimal;

public class ProductTestBuilder {

    public static BasicProduct basicProduct() {
        return new BasicProduct(1L, "Basic Test Product", "Basic Description", BigDecimal.TEN, PricingStrategy.DEFAULT);
    }

    public static StandardProduct standardProduct() {
        return new StandardProduct(2L, "Standard Test Product", "Standard Description", BigDecimal.valueOf(20), PricingStrategy.DEFAULT);
    }

    public static DefaultProduct defaultProduct() {
        return new DefaultProduct(3L, "Default Test Product", "Default Description", BigDecimal.valueOf(15) , PricingStrategy.DEFAULT);
    }

    public static ProductRequest basicProductRequest() {
        return new ProductRequest("Basic Test Product", "Basic Description", BigDecimal.TEN, "BASIC");
    }

    public static ProductRequest standardProductRequest() {
        return new ProductRequest("Standard Test Product", "Standard Description", BigDecimal.valueOf(20), "STANDARD");
    }

    public static ProductRequest defaultProductRequest() {
        return new ProductRequest("Default Test Product", "Default Description", BigDecimal.valueOf(15), "DEFAULT");
    }

    public static ProductEntity basicProductEntity() {
        return new ProductEntity(1L, "Basic Test Product", "Basic Description", BigDecimal.TEN, "BASIC");
    }

    public static ProductEntity standardProductEntity() {
        return new ProductEntity(1L, "Standard Test Product", "Basic Description", BigDecimal.TEN, "STANDARD");
    }

    public static ProductEntity defaultProductEntity() {
        return new ProductEntity(1L, "Default Test Product", "Default Description", BigDecimal.TEN, "DEFAULT");
    }

    public static ProductEntity savedBasicProductEntity() {
        return new ProductEntity(1L, "Basic Test Product", "Basic Description", BigDecimal.TEN, "BASIC");
    }

    public static ProductEntity savedStandardProductEntity() {
        return new ProductEntity(1L, "Standard Test Product", "Basic Description", BigDecimal.TEN, "STANDARD");
    }

    public static ProductEntity savedDefaultProductEntity() {
        return new ProductEntity(1L, "Default Test Product", "Basic Description", BigDecimal.TEN, "DEFAULT");
    }


    public static class CustomProductBuilder {
        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
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

        public CustomProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public CustomProductBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Product build() {
            return switch (type.toUpperCase()) {
                case "BASIC" -> new BasicProduct(id, name, description, price, PricingStrategy.DEFAULT);
                case "STANDARD" -> new StandardProduct(id, name, description, price, PricingStrategy.DEFAULT);
                case "DEFAULT" -> new DefaultProduct(id, name, description, price, PricingStrategy.DEFAULT);
                default -> throw new IllegalArgumentException("Unknown product type");
            };
        }

        public static CustomProductBuilder customProduct() {
            return new CustomProductBuilder();
        }

    }
}
