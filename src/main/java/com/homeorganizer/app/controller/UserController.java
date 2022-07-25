package com.homeorganizer.app.controller;

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

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        return userService.createUser(userDetails);
    }

    @DeleteMapping(path="/{userId}")
    public UserRest deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping(path = "/{userId}")
    public UserRest getUserById(@PathVariable String userId) {
        return userService.getUserByUserId(userId);
    }

    @PutMapping(path="/{userId}")
    public UserRest updateUser(@RequestBody UserDetailsRequestModel userDetails, @PathVariable String userId) {
        return userService.updateUser(userId, userDetails);
    }
}
