package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.dto.UserDto;
import pl.home.organizer.application.entity.UserEntity;
import pl.home.organizer.application.repository.UserRepository;
import pl.home.organizer.application.service.UserService;
import pl.home.organizer.application.utils.IdGenerator;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;

    @Override
    public UserDto createUser(UserDto user) {

        if (userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("The email address already exists!");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setId(idGenerator.generateUserId(30));

        userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);

        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String id) {
        UserEntity userEntity = userRepository.findById(id);

        if (userEntity == null) throw new RuntimeException("User not found!");

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) {
        UserEntity userEntity = userRepository.findById(userId);
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDto deleteUser(String userId) {
        UserEntity userEntity = userRepository.findById(userId);

        userRepository.delete(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }
}