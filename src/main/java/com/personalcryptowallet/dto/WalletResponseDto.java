package com.personalcryptowallet.dto;

import com.personalcryptowallet.model.Coin;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public record WalletResponseDto(
        UUID id,
        String name,
        BigDecimal balance,
        BigDecimal totalContribuition,
        BigDecimal UserService,
        Set<Coin> coins
) {
}
