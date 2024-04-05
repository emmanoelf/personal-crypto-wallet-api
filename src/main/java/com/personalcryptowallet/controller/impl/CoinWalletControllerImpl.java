package com.personalcryptowallet.controller.impl;

import com.personalcryptowallet.controller.CoinWalletController;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import com.personalcryptowallet.service.CoinWalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/wallet/coin")
public class CoinWalletControllerImpl implements CoinWalletController {

    private CoinWalletService coinWalletService;

    public CoinWalletControllerImpl(CoinWalletService coinWalletService){
        this.coinWalletService = coinWalletService;
    }

    @Override
    @GetMapping
    public ResponseEntity<CoinMarketCapResponseDto> getCoin(@RequestParam String slug) {
        return ResponseEntity.status(HttpStatus.OK).body(this.coinWalletService.getCoin(slug));
    }
}
