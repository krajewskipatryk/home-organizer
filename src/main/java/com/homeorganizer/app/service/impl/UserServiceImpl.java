package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.dto.UserDto;
import com.homeorganizer.app.entity.UserEntity;
import com.homeorganizer.app.mapper.UserMapper;
import com.homeorganizer.app.repository.UserRepository;
import com.homeorganizer.app.service.UserService;
import com.homeorganizer.app.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        if (userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("The email address already exists!");

        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(user);
        userEntity.setId(IdGenerator.generateUserId(15));

        userRepository.save(userEntity);

        return UserMapper.INSTANCE.userEntityToUserDto(userEntity);
    }


    @Override
    public UserDto getUserByUserId(String id) {
        UserEntity userEntity = userRepository.findUserById(id);

        if (userEntity == null) throw new RuntimeException("User not found!");

        return UserMapper.INSTANCE.userEntityToUserDto(userEntity);
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) {
        UserEntity userEntity = userRepository.findUserById(userId);
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userRepository.save(userEntity);

        return UserMapper.INSTANCE.userEntityToUserDto(userEntity);
    }

    @Override
    public UserDto deleteUser(String userId) {
        UserEntity userEntity = userRepository.findUserById(userId);

        userRepository.delete(userEntity);

        return UserMapper.INSTANCE.userEntityToUserDto(userEntity);
    }
}