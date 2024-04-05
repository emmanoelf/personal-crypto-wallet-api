package com.personalcryptowallet.controller;

import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import org.springframework.http.ResponseEntity;

public interface CoinWalletController {
    ResponseEntity<CoinMarketCapResponseDto> getCoin(String slug);
}
