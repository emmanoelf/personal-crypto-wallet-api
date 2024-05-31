package com.personalcryptowallet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CoinDto(
        @NotNull Long idCoinMarketCap,
        @NotNull @NotBlank String slug,
        @NotNull @NotBlank String symbol,
        @NotNull BigDecimal price,
        @NotNull BigDecimal contributionValue,
        @NotNull BigDecimal quantity,
        @NotNull LocalDateTime dateContribution,
        BigDecimal brokerFee
) {
}
