package com.personalcryptowallet.controller;

import com.personalcryptowallet.dto.WalletDto;
import com.personalcryptowallet.dto.WalletResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "Wallet Controller")
public interface WalletController {
    @Operation(summary = "Create a new wallet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Create a new wallet for user",
                    content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<WalletResponseDto> save(UUID userId, WalletDto walletDto);

    @Operation(summary = "Search a wallet for name and show it")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Search for a name wallet",
            content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<WalletResponseDto> show(UUID userId, String name);

    @Operation(summary = "Delete an wallet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Delete a wallet by ID",
            content = {@Content(mediaType = "application/jsoon")})
    })
    ResponseEntity<Long> delete(UUID userId, UUID walletId);

    @Operation(summary = "Rename a wallet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Rename a wallet by ID",
            content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<WalletResponseDto> rename(UUID userId, UUID walletId, WalletDto walletDto);
}
