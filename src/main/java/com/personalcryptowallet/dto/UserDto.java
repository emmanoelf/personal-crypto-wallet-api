package com.personalcryptowallet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UserDto(
        @NotNull @NotBlank String email,
        @NotNull @NotBlank String password,
        @NotNull List<WalletDto> walletList) {
}
