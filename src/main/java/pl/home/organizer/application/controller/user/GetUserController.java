package pl.home.organizer.application.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.home.organizer.application.dto.UserDto;
import pl.home.organizer.application.model.response.UserRest;
import pl.home.organizer.application.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class GetUserController {
    private final UserService userService;

    @GetMapping(path = "/{userId}")
    public UserRest getUserById(@PathVariable String userId) {
        UserRest returnValue = new UserRest();

        UserDto userDto = userService.getUserByUserId(userId);
        BeanUtils.copyProperties(userDto, returnValue);

        return returnValue;
    }
}
