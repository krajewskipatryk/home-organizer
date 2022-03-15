package pl.home.organizer.application.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.home.organizer.application.dto.UserDto;

public interface UserService extends UserDetailsService {
    public UserDto createUser(UserDto customer);
}