package com.oneclick.productservice.dto;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal basePrice, BigDecimal finalPrice, String type) {}
