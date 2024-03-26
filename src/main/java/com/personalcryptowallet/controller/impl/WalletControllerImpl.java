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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<WalletResponseDto> save(@PathVariable @Valid UUID userId, @Valid @RequestBody WalletDto walletDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.walletService.save(userId, walletDto));
    }

    @Override
    @GetMapping(value = "/{userId}")
    public ResponseEntity<WalletResponseDto> show(@PathVariable @Valid UUID userId, @RequestParam(value = "name") String name){
        return ResponseEntity.ok(this.walletService.find(userId, name));
    }

    @Override
    @DeleteMapping("/{userId}/{walletId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable @Valid UUID userId, @PathVariable @Valid UUID walletId) {
        this.walletService.delete(userId, walletId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{userId}/{walletId}")
    public ResponseEntity<WalletResponseDto> rename(@PathVariable @Valid UUID userId,
                                                    @PathVariable @Valid UUID walletId,
                                                    @RequestBody WalletDto walletDto) {
        return ResponseEntity.ok(this.walletService.rename(userId, walletId, walletDto));
    }
}
