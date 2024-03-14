package com.personalcryptowallet.controller;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {
    ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserDto userDto);
}
