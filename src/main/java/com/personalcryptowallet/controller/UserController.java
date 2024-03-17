package com.personalcryptowallet.controller;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserController {
    ResponseEntity<UserResponseDto> save(UserDto userDto);
    ResponseEntity<UserResponseDto> findUser(UUID id);
}
