package com.personalcryptowallet.service;

import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;

public interface CoinWalletService {
    CoinMarketCapResponseDto getCoin(String slug);
}
