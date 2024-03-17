package com.personalcryptowallet.mapper;

import com.personalcryptowallet.dto.UserDto;
import com.personalcryptowallet.dto.UserResponseDto;
import com.personalcryptowallet.model.User;

public class UserMapper {

    public static User toModel(UserDto userDto){

        return User.builder()
                .email(userDto.email())
                .password(userDto.password())
                .wallets(WalletMapper.toModelCollection(userDto.walletList()))
                .build();
    }

    public static UserResponseDto toDto(User user){
        return new UserResponseDto(user.getId(), user.getEmail(), user.getPassword(), WalletMapper.toDtoCollection(user.getWallets()));
    }
}
