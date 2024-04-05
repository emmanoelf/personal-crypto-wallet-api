package com.personalcryptowallet.service.impl;

import com.personalcryptowallet.client.CoinMarketCapClient;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import com.personalcryptowallet.service.CoinWalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoinWalletServiceImpl implements CoinWalletService {

    private final CoinMarketCapClient coinMarketCapClient;

    @Override
    public CoinMarketCapResponseDto getCoin(String slug) {
        return this.coinMarketCapClient.getCoin(slug);
    }
}
