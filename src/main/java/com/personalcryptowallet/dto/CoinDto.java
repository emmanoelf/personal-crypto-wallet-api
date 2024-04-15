package com.personalcryptowallet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CoinDto(
        @NotNull @NotBlank Long idCoinMarketCap,
        @NotNull @NotBlank String slug,
        @NotNull @NotBlank String symbol,
        @NotNull @NotBlank BigDecimal price,
        @NotNull @NotBlank  BigDecimal quantity,
        @NotNull @NotBlank LocalDateTime dateContribuition,
        BigDecimal brokerFee
) {
}
