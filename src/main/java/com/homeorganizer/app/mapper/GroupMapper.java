package com.homeorganizer.app.mapper;

import com.homeorganizer.app.dto.GroupDto;
import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.model.request.GroupCreationRequestModel;
import com.homeorganizer.app.model.response.GroupRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    @Mapping(target = "groupName", source = "groupName")
    GroupDto groupDetailsToGroupDto(GroupCreationRequestModel groupDetails);
    GroupEntity groupDtoToGroupEntity(GroupDto groupDto);
    GroupDto groupEntityToGroupDto(GroupEntity groupEntity);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "groupName", source = "groupName")
    GroupRest groupDtoToGroupRest(GroupDto groupDto);
}
