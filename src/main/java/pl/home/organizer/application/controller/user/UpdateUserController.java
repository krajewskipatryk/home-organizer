package pl.home.organizer.application.controller.user;

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
public class UpdateUserController {
    private final UserService userService;

    @PutMapping(path="/{userId}")
    public UserRest updateUser(@RequestBody UserDetailsRequestModel userDetails, @PathVariable String userId) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto updatedUser = userService.updateUser(userId, userDto);
        BeanUtils.copyProperties(updatedUser, returnValue);

        return returnValue;
    }
}
