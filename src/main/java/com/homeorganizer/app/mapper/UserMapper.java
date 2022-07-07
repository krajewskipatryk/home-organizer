package com.homeorganizer.app.mapper;

import com.homeorganizer.app.dto.UserDto;
import com.homeorganizer.app.entity.UserEntity;
import com.homeorganizer.app.model.request.UserDetailsRequestModel;
import com.homeorganizer.app.model.response.UserRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    UserDto userEntityToUserDto(UserEntity userEntity);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    UserDto userDetailsToUserDto(UserDetailsRequestModel userDetails);

    UserEntity userDtoToUserEntity(UserDto userDto);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "id", source = "id")
    UserRest userDtoToUserRest(UserDto userDto);
}
