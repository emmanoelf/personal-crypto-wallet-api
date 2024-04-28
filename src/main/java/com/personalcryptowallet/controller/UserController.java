package com.personalcryptowallet.controller;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "User Controller")
public interface UserController {
    @Operation(summary = "Create users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Create a user",
                    content = {@Content(mediaType = "application/json")})
            })
    ResponseEntity<UserResponseDto> save(@Parameter(description = "email, password and name of wallet")
                                         UserDto userDto);

    @Operation(summary = "Find user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Find a user by ID",
                    content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<UserResponseDto> findUser(UUID id);
}
