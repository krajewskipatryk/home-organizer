package pl.home.organizer.application.service;


import pl.home.organizer.application.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUser(String email);
    UserDto getUserByUserId(String id);
    UserDto updateUser(String id, UserDto user);
    UserDto deleteUser(String id);
}