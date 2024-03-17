package com.personalcryptowallet.controller.impl;

import com.personalcryptowallet.controller.WalletController;
import com.personalcryptowallet.dto.WalletDto;
import com.personalcryptowallet.dto.WalletResponseDto;
import com.personalcryptowallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/wallets")
public class WalletControllerImpl implements WalletController {

    private WalletService walletService;

    public WalletControllerImpl(WalletService walletService){
        this.walletService = walletService;
    }

    @Override
    @PostMapping("/{userId}")
    public ResponseEntity<WalletResponseDto> save(@PathVariable @Valid UUID userId, @Valid @RequestBody WalletDto walletDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.walletService.save(userId, walletDto));
    }
}
