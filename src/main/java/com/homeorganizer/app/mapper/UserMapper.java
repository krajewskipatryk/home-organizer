package com.homeorganizer.app.mapper;

import com.homeorganizer.app.entity.UserEntity;
import com.homeorganizer.app.model.request.UserDetailsRequestModel;
import com.homeorganizer.app.model.response.UserRest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity userDetailsToUserEntity(UserDetailsRequestModel userDetails);
    UserRest userEntityToUserRest(UserEntity userEntity);
}
