package com.personalcryptowallet.controller.impl;

import com.personalcryptowallet.controller.UserController;
import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;
import com.personalcryptowallet.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserDto userDto) {
        UserResponseDto userResponseDto = this.userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUser(@Valid @PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findUser(id));
    }
}
