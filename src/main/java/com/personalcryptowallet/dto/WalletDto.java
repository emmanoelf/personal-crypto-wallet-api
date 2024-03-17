package com.personalcryptowallet.dto;

import jakarta.validation.constraints.NotNull;

public record WalletDto(
        @NotNull String name
) {
}
