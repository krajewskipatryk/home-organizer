package com.homeorganizer.app.service;


import com.homeorganizer.app.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserByUserId(String id);
    UserDto updateUser(String id, UserDto user);
    UserDto deleteUser(String id);
}