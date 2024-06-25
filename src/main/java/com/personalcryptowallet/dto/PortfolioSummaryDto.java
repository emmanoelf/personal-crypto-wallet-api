package com.personalcryptowallet.dto;

import java.math.BigDecimal;

public record PortfolioSummaryDto(
        BigDecimal totalInvested,
        BigDecimal balance,
        BigDecimal currentProfitOrLoss,
        String currentProfitOrLossPercentage
) {
}
