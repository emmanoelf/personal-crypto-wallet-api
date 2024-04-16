package com.personalcryptowallet.service.impl;

import com.personalcryptowallet.client.CoinMarketCapClient;
import com.personalcryptowallet.dto.CoinDto;
import com.personalcryptowallet.dto.CoinResponseDto;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import com.personalcryptowallet.mapper.CoinMapper;
import com.personalcryptowallet.model.Coin;
import com.personalcryptowallet.model.Wallet;
import com.personalcryptowallet.repository.CoinRepository;
import com.personalcryptowallet.repository.WalletRepository;
import com.personalcryptowallet.service.CoinWalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CoinWalletServiceImpl implements CoinWalletService {

    private final CoinMarketCapClient coinMarketCapClient;
    private final CoinRepository coinRepository;
    private final WalletRepository walletRepository;

    @Override
    public CoinMarketCapResponseDto getCoin(String slug) {
        return this.coinMarketCapClient.getCoin(slug);
    }

    @Override
    public CoinResponseDto addCoin(UUID walletId, CoinDto coinDto) {
        Coin coin = CoinMapper.toModel(coinDto);

        Wallet wallet = this.walletRepository.findWithoutCoin(walletId);
        coin.setWallet(Collections.singleton(wallet));

        Coin savedCoin = this.coinRepository.save(coin);

        return CoinMapper.toDto(savedCoin);
    }
}
