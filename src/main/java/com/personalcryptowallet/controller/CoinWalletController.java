package com.personalcryptowallet.controller;

import com.personalcryptowallet.dto.CoinDto;
import com.personalcryptowallet.dto.CoinResponseDto;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CoinWalletController {
    ResponseEntity<CoinMarketCapResponseDto> getCoin(String slug);
    ResponseEntity<CoinResponseDto> addCoin(UUID walletId, CoinDto coinDto);
}
