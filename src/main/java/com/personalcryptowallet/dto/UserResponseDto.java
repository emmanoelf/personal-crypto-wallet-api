package com.personalcryptowallet.dto;

import java.util.List;
import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String email,
        String password,
        List<WalletResponseDto> walletList
) {
}
