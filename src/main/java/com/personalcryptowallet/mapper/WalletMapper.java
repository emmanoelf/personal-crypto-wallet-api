package com.personalcryptowallet.mapper;

import com.personalcryptowallet.dto.WalletDto;
import com.personalcryptowallet.dto.WalletResponseDto;
import com.personalcryptowallet.model.Wallet;

import java.util.List;
import java.util.stream.Collectors;

public class WalletMapper {

    public static Wallet toModel(WalletDto walletDto) {
        return Wallet.builder()
                .name(walletDto.name())
                .build();
    }

    public static List<Wallet> toModelCollection(List<WalletDto> walletsDtoList) {
        return walletsDtoList.stream()
                .map(WalletMapper::toModel)
                .collect(Collectors.toList());
    }

    public static WalletResponseDto toDto(Wallet wallet){
        return new WalletResponseDto(
                wallet.getId(),
                wallet.getName(),
                wallet.getBalance(),
                wallet.getTotalContribuition(),
                wallet.getProfitAndLose(),
                wallet.getCoins());
    }

    public static List<WalletResponseDto> toDtoCollection(List<Wallet> walletsList){
        return walletsList.stream()
                .map(WalletMapper::toDto)
                .collect(Collectors.toList());
    }

}
