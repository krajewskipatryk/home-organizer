package com.homeorganizer.app.service.impl;


import com.homeorganizer.app.entity.UserEntity;
import com.homeorganizer.app.mapper.UserMapper;
import com.homeorganizer.app.model.request.UserDetailsRequestModel;
import com.homeorganizer.app.model.response.UserRest;
import com.homeorganizer.app.repository.UserRepository;
import com.homeorganizer.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserRest createUser(UserDetailsRequestModel user) {
        UserEntity userEntity = userMapper.userDetailsToUserEntity(user);
        userEntity.setId(String.valueOf(UUID.randomUUID()));

        userRepository.save(userEntity);

        return userMapper.userEntityToUserRest(userEntity);
    }

    @Override
    public UserRest getUserByUserId(String id) {
        UserEntity userEntity = userRepository.findUserById(id);

        return userMapper.userEntityToUserRest(userEntity);
    }

    @Override
    public UserEntity getUserEntityById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public UserRest updateUser(String userId, UserDetailsRequestModel user) {
        UserEntity userEntity = userRepository.findUserById(userId);
        userEntity = userMapper.userDetailsToUserEntity(user);
        userRepository.save(userEntity);

        return userMapper.userEntityToUserRest(userEntity);
    }

    @Override
    public UserRest deleteUser(String userId) {
        UserEntity userEntity = userRepository.findUserById(userId);

        userRepository.delete(userEntity);

        return userMapper.userEntityToUserRest(userEntity);
    }
}