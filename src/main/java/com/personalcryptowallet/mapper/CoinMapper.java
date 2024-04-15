package com.personalcryptowallet.mapper;

import com.personalcryptowallet.dto.CoinDto;
import com.personalcryptowallet.dto.CoinResponseDto;
import com.personalcryptowallet.model.Coin;

public class CoinMapper {
    public static Coin toModel(CoinDto coinDto){
        return Coin.builder()
                .idCoinMarketCap(coinDto.idCoinMarketCap())
                .slug(coinDto.slug())
                .symbol(coinDto.symbol())
                .price(coinDto.price())
                .quantity(coinDto.quantity())
                .dateContribution(coinDto.dateContribuition())
                .brokerFee(coinDto.brokerFee())
                .build();
    }

    public static CoinResponseDto toDto(Coin coin){
        return new CoinResponseDto(
                coin.getId(),
                coin.getSlug(),
                coin.getSymbol(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getDateContribution(),
                coin.getBrokerFee());
    }
}
