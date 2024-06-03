package com.personalcryptowallet.model.projection;

import java.math.BigDecimal;

public record PortfolioSummaryProjection(
        Long idCoinMarketCap,
        String slug,
        BigDecimal totalQuantity,
        BigDecimal totalInvested,
        BigDecimal averagePrice
) {}