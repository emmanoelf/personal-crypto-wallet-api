package com.personalcryptowallet.controller;

import com.personalcryptowallet.dto.CoinDto;
import com.personalcryptowallet.dto.CoinResponseDto;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "Coin Wallet Controller")
public interface CoinWalletController {
    @Operation(description = "Get a coin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Return the searched coin",
            content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<CoinMarketCapResponseDto> getCoin(String slug);

    @Operation(description = "Add a coin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Add searched coin to your wallet",
            content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<CoinResponseDto> addCoin(UUID walletId, CoinDto coinDto);
}
