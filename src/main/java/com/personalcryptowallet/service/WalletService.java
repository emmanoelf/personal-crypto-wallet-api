package com.personalcryptowallet.service;

import com.personalcryptowallet.dto.WalletDto;
import com.personalcryptowallet.dto.WalletResponseDto;

import java.util.UUID;

public interface WalletService {
    WalletResponseDto save(UUID userId, WalletDto walletDto);
    WalletResponseDto find(UUID userId, String nameWallet);
    void delete(UUID userId, UUID walletId);
    WalletResponseDto rename(UUID userId, UUID walletId, String nameWallet);
}
