package com.personalcryptowallet.service.impl;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;
import com.personalcryptowallet.exceptions.EntidadeNaoEncontradaException;
import com.personalcryptowallet.mapper.UserMapper;
import com.personalcryptowallet.model.User;
import com.personalcryptowallet.repository.UserRepository;
import com.personalcryptowallet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto save(UserDto userDto) {
        User user = UserMapper.toModel(userDto);
        user = this.userRepository.save(user);

        return UserMapper.toDto(user);
    }

    @Override
    public UserResponseDto findUser(UUID userId) {
        Optional<User> user = this.userRepository.findById(userId);

        if(user.isEmpty()){
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }

        return UserMapper.toDto(user.get());
    }
}