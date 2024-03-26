package com.personalcryptowallet.service.impl;

import com.personalcryptowallet.dto.WalletDto;
import com.personalcryptowallet.dto.WalletResponseDto;
import com.personalcryptowallet.exceptions.EntidadeNaoEncontradaException;
import com.personalcryptowallet.mapper.WalletMapper;
import com.personalcryptowallet.model.User;
import com.personalcryptowallet.model.Wallet;
import com.personalcryptowallet.repository.UserRepository;
import com.personalcryptowallet.repository.WalletRepository;
import com.personalcryptowallet.service.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    @Transactional
    @Override
    public WalletResponseDto save(UUID userId, WalletDto walletDto) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));

        Wallet wallet = WalletMapper.toModel(walletDto);
        wallet.setUser(user);

        wallet = walletRepository.save(wallet);

        return WalletMapper.toDto(wallet);
    }

    @Override
    public WalletResponseDto find(UUID userId, String nameWallet) {
        Optional<Wallet> wallet = this.walletRepository.findByNameAndUserId(nameWallet, userId);

        if (wallet.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Carteira não encontrada");
        }

        return WalletMapper.toDto(wallet.get());
    }

    @Override
    public void delete(UUID userId, UUID walletId) {
        Optional<Wallet> wallet = this.walletRepository.findByIdAndUserId(walletId, userId);

        if(wallet.isEmpty()){
            throw new EntidadeNaoEncontradaException("Carteira não encontrada");
        }

        this.walletRepository.delete(wallet.get());
    }

    @Override
    public WalletResponseDto rename(UUID userId, UUID walletId, String nameWallet) {
        return null;
    }
}
