package com.personalcryptowallet.service.impl;

import com.personalcryptowallet.dto.WalletDto;
import com.personalcryptowallet.dto.WalletResponseDto;
import com.personalcryptowallet.exceptions.EntidadeNaoEncontradaException;
import com.personalcryptowallet.mapper.WalletMapper;
import com.personalcryptowallet.model.User;
import com.personalcryptowallet.model.Wallet;
import com.personalcryptowallet.repository.UserRepository;
import com.personalcryptowallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final UserRepository userRepository;

    @Override
    public WalletResponseDto save(UUID userId, WalletDto walletDto) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));

        Wallet wallet = WalletMapper.toModel(walletDto);

        user.getWallets().add(wallet);

        this.userRepository.save(user);

        return WalletMapper.toDto(wallet);
    }

    @Override
    public WalletResponseDto find(UUID userId, UUID walletId) {
        return null;
    }

    @Override
    public WalletResponseDto delete(UUID userId, UUID walletId) {
        return null;
    }

    @Override
    public WalletResponseDto rename(UUID userId, UUID walletId) {
        return null;
    }
}
