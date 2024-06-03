package com.personalcryptowallet.repository;

import com.personalcryptowallet.model.projection.PortfolioSummaryProjection;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoinCustomRepository {
    List<PortfolioSummaryProjection> findPortfolioSummary(UUID walletId);
}
