package pl.home.organizer.application.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import pl.home.organizer.application.dto.UserDto;
import pl.home.organizer.application.mapper.UserMapper;
import pl.home.organizer.application.model.request.UserDetailsRequestModel;
import pl.home.organizer.application.model.response.UserRest;
import pl.home.organizer.application.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserDto userDto;
        userDto = UserMapper.INSTANCE.userDetailsToUserDto(userDetails);
        UserDto createdCustomer = userService.createUser(userDto);

        return UserMapper.INSTANCE.userDtoToUserRest(createdCustomer);
    }

    @DeleteMapping(path="/{userId}")
    public UserRest deleteUser(@PathVariable String userId) {
        UserDto userDto = userService.deleteUser(userId);

        return UserMapper.INSTANCE.userDtoToUserRest(userDto);
    }

    @GetMapping(path = "/{userId}")
    public UserRest getUserById(@PathVariable String userId) {
        UserDto userDto = userService.getUserByUserId(userId);

        return UserMapper.INSTANCE.userDtoToUserRest(userDto);
    }

    @PutMapping(path="/{userId}")
    public UserRest updateUser(@RequestBody UserDetailsRequestModel userDetails, @PathVariable String userId) {
        UserDto userDto;
        userDto = UserMapper.INSTANCE.userDetailsToUserDto(userDetails);

        UserDto updatedUser = userService.updateUser(userId, userDto);

        return UserMapper.INSTANCE.userDtoToUserRest(updatedUser);
    }
}
