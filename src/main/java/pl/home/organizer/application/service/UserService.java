package pl.home.organizer.application.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.home.organizer.application.dto.UserDto;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUser(String email);
    UserDto getUserByUserId(String userId);
    UserDto updateUser(String userId, UserDto user);
    UserDto deleteUser(String userId);
}