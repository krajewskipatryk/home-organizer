package pl.home.organizer.application.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.home.organizer.application.dto.UserDto;
import pl.home.organizer.application.model.response.UserRest;
import pl.home.organizer.application.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class DeleteUserController {
    private final UserService userService;

    @DeleteMapping(path="/{userId}")
    public UserRest deleteUser(@PathVariable String userId) {
        UserDto userDto = userService.deleteUser(userId);

        UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(userDto, returnValue);

        return returnValue;
    }
}
