package com.homeorganizer.app.mapper;

import com.homeorganizer.app.dto.GroupDto;
import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.model.request.GroupCreationRequestModel;
import com.homeorganizer.app.model.response.GroupRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupEntity groupDetailsToGroupEntity(GroupCreationRequestModel groupDetails);
    GroupRest groupEntityToGroupRest(GroupEntity groupEntity);
}
