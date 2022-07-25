package com.homeorganizer.app.service;


import com.homeorganizer.app.dto.UserDto;
import com.homeorganizer.app.entity.UserEntity;
import com.homeorganizer.app.model.request.UserDetailsRequestModel;
import com.homeorganizer.app.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel user);
    UserRest getUserByUserId(String id);
    UserEntity getUserEntityById(String id);
    UserRest updateUser(String id, UserDetailsRequestModel user);
    UserRest deleteUser(String id);
}