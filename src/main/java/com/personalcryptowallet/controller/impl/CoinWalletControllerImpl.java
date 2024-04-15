package com.personalcryptowallet.controller.impl;

import com.personalcryptowallet.controller.CoinWalletController;
import com.personalcryptowallet.dto.CoinDto;
import com.personalcryptowallet.dto.CoinResponseDto;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import com.personalcryptowallet.service.CoinWalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/wallet/{walletId}")
public class CoinWalletControllerImpl implements CoinWalletController {

    private final CoinWalletService coinWalletService;

    public CoinWalletControllerImpl(CoinWalletService coinWalletService){
        this.coinWalletService = coinWalletService;
    }

    @Override
    @GetMapping(path = "/coin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoinMarketCapResponseDto> getCoin(@RequestParam String slug) {
        return ResponseEntity.status(HttpStatus.OK).body(this.coinWalletService.getCoin(slug));
    }

    @Override
    @PostMapping(path = "/coin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoinResponseDto> addCoin(@PathVariable UUID walletId, @RequestBody CoinDto coinDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.coinWalletService.addCoin(walletId, coinDto));
    }
}
