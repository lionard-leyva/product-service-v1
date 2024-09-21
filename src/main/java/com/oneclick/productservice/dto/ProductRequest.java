package com.oneclick.productservice.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        @NotNull String name,
        @NotNull String description,
        @NotNull BigDecimal basePrice,
        @Nullable BigDecimal finalPrice,
        @NotNull String type) {
}