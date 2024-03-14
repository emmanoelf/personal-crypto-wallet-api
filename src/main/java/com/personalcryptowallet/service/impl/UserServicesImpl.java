package com.personalcryptowallet.service.impl;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;
import com.personalcryptowallet.mapper.UserMapper;
import com.personalcryptowallet.model.User;
import com.personalcryptowallet.repository.UserRepository;
import com.personalcryptowallet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}