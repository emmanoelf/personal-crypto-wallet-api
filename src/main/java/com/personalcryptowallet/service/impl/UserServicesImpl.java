package com.personalcryptowallet.service.impl;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;
import com.personalcryptowallet.exceptions.EntidadeNaoEncontradaException;
import com.personalcryptowallet.mapper.UserMapper;
import com.personalcryptowallet.model.User;
import com.personalcryptowallet.model.Wallet;
import com.personalcryptowallet.repository.UserRepository;
import com.personalcryptowallet.repository.WalletRepository;
import com.personalcryptowallet.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    @Transactional
    @Override
    public UserResponseDto save(UserDto userDto) {
        User user = UserMapper.toModel(userDto);
        User savedUser = this.userRepository.save(user);

        if (!user.getWallets().isEmpty()) {
            user.getWallets().forEach(wallet -> wallet.setUser(savedUser));
            List<Wallet> walletList = walletRepository.saveAll(user.getWallets());
            savedUser.setWallets(walletList);
        }

        return UserMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDto findUser(UUID userId) {
        Optional<User> user = this.userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }

        return UserMapper.toDto(user.get());
    }
}