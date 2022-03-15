package pl.home.organizer.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pl.home.organizer.application.dto.UserDto;
import pl.home.organizer.application.model.request.UserDetailsRequestModel;
import pl.home.organizer.application.model.response.UserRest;
import pl.home.organizer.application.service.UserService;


@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getUser() {
        return "MC Young Fatstarson on mic!";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdCustomer = userService.createUser(userDto);
        BeanUtils.copyProperties(createdCustomer, returnValue);

        return returnValue;
    }
}
