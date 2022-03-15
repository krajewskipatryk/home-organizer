package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.dto.UserDto;
import pl.home.organizer.application.entity.UserEntity;
import pl.home.organizer.application.repository.UserRepository;
import pl.home.organizer.application.service.UserService;
import pl.home.organizer.application.utils.UserIdGenerator;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserIdGenerator userIdGenerator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto customer) {

        if (userRepository.findByEmail(customer.getEmail()) != null) throw new RuntimeException("The email address already exists!");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(customer, userEntity);

        userEntity.setUserId(userIdGenerator.generateUserId(30));
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(customer.getPassword()));

        userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}