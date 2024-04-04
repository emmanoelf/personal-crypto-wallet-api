package com.personalcryptowallet.controller;

import com.personalcryptowallet.dto.WalletDto;
import com.personalcryptowallet.dto.WalletResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface WalletController {
    ResponseEntity<WalletResponseDto> save(UUID userId, WalletDto walletDto);
    ResponseEntity<WalletResponseDto> show(UUID userId, String name);
    ResponseEntity<Long> delete(UUID userId, UUID walletId);
    ResponseEntity<WalletResponseDto> rename(UUID userId, UUID walletId, WalletDto walletDto);
}
