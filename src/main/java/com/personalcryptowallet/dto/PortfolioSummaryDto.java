package com.personalcryptowallet.dto;

import java.math.BigDecimal;
import java.util.List;

public record PortfolioSummaryDto(
        BigDecimal totalInvested,
        BigDecimal balance,
        BigDecimal currentProfitOrLoss,
        String currentProfitOrLossPercentage,
        List<PortfolioSummaryCoinDto> coins
) {
}
