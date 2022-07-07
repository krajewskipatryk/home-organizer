package com.homeorganizer.app.controller;

import com.homeorganizer.app.dto.UserDto;
import com.homeorganizer.app.mapper.UserMapper;
import com.homeorganizer.app.model.request.UserDetailsRequestModel;
import com.homeorganizer.app.model.response.UserRest;
import com.homeorganizer.app.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserDto userDto = userMapper.userDetailsToUserDto(userDetails);
        UserDto createdCustomer = userService.createUser(userDto);

        return userMapper.userDtoToUserRest(createdCustomer);
    }

    @DeleteMapping(path="/{userId}")
    public UserRest deleteUser(@PathVariable String userId) {
        UserDto userDto = userService.deleteUser(userId);

        return userMapper.userDtoToUserRest(userDto);
    }

    @GetMapping(path = "/{userId}")
    public UserRest getUserById(@PathVariable String userId) {
        UserDto userDto = userService.getUserByUserId(userId);

        return userMapper.userDtoToUserRest(userDto);
    }

    @PutMapping(path="/{userId}")
    public UserRest updateUser(@RequestBody UserDetailsRequestModel userDetails, @PathVariable String userId) {
        UserDto userDto = userMapper.userDetailsToUserDto(userDetails);

        UserDto updatedUser = userService.updateUser(userId, userDto);

        return userMapper.userDtoToUserRest(updatedUser);
    }
}
