package com.personalcryptowallet.service;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;

public interface UserService {
    UserResponseDto save(UserDto userDto);
}
