package com.personalcryptowallet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record UserDto(
        @NotNull String email,
        @NotNull String password) {}
