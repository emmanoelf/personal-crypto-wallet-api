package com.personalcryptowallet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CoinResponseDto(
        UUID id,
        String slug,
        String symbol,
        BigDecimal price,
        BigDecimal quantity,
        BigDecimal contributionValue,
        LocalDateTime dateContribution,
        BigDecimal brokerFee
) {
}
