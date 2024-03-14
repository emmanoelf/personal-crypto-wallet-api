package com.personalcryptowallet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotNull @NotBlank String email,
        @NotNull @NotBlank String password) {}
