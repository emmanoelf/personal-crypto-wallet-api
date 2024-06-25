package com.personalcryptowallet.service;

import com.personalcryptowallet.dto.CoinDto;
import com.personalcryptowallet.dto.CoinResponseDto;
import com.personalcryptowallet.dto.PortfolioSummaryDto;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;

import java.util.UUID;

public interface CoinWalletService {
    CoinMarketCapResponseDto getCoin(String slug);
    CoinResponseDto addCoin(UUID walletId, CoinDto coinDto);
    PortfolioSummaryDto showSummary(UUID walletId);
}
