package pl.home.organizer.application.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.home.organizer.application.dto.UserDto;
import pl.home.organizer.application.exceptions.UserServiceException;
import pl.home.organizer.application.model.request.UserDetailsRequestModel;
import pl.home.organizer.application.model.response.ErrorMessages;
import pl.home.organizer.application.model.response.UserRest;
import pl.home.organizer.application.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class CreateUserController {
    private final UserService userService;

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
        UserRest returnValue = new UserRest();

        if (userDetails.getFirstName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdCustomer = userService.createUser(userDto);
        BeanUtils.copyProperties(createdCustomer, returnValue);

        return returnValue;
    }
}
