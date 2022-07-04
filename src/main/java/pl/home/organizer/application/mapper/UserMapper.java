package pl.home.organizer.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.home.organizer.application.dto.UserDto;
import pl.home.organizer.application.entity.UserEntity;
import pl.home.organizer.application.model.request.UserDetailsRequestModel;
import pl.home.organizer.application.model.response.UserRest;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDto userEntityToUserDto(UserEntity userEntity);
    UserDto userDetailsToUserDto(UserDetailsRequestModel userDetails);
    UserEntity userDtoToUserEntity(UserDto userDto);
    UserRest userDtoToUserRest(UserDto userDto);
}
