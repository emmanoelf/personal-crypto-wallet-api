package com.personalcryptowallet.dto;

import java.math.BigDecimal;

public record PortfolioSummaryCoinDto(
        String slug,
        BigDecimal currentPrice,
        BigDecimal balance,
        BigDecimal totalQuantity,
        BigDecimal totalInvested,
        BigDecimal averagePrice,
        BigDecimal profitOrLoss,
        String percentageProfitOrLoss
) {
}