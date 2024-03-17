package com.personalcryptowallet.service;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;

import java.util.UUID;

public interface UserService {
    UserResponseDto save(UserDto userDto);
    UserResponseDto findUser(UUID userId);
}
