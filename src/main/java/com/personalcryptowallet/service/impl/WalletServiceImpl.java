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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    @Override
    public WalletResponseDto save(UUID userId, WalletDto walletDto) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));

        List<Wallet> wallets = this.walletRepository.findAllByUserId(userId);

        Wallet newWallet = WalletMapper.toModel(walletDto);

        wallets.add(newWallet);
        newWallet.setUser(user);
        user.setWallets(wallets);

        this.userRepository.save(user);

        return WalletMapper.toDto(newWallet);
    }

    @Override
    public WalletResponseDto find(UUID userId, String nameWallet) {
        this.userRepository.findById(userId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));
        Optional<Wallet> wallet = this.walletRepository.findByName(nameWallet);

        if(wallet.isEmpty()){
            throw new EntidadeNaoEncontradaException("Carteira não encontrada");
        }

        return WalletMapper.toDto(wallet.get());
    }

    @Override
    public WalletResponseDto delete(UUID userId, UUID walletId) {
        return null;
    }

    @Override
    public WalletResponseDto rename(UUID userId, UUID walletId, String nameWallet) {
        return null;
    }
}
