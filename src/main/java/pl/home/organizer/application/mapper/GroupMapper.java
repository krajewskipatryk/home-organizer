package pl.home.organizer.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.home.organizer.application.dto.GroupDto;
import pl.home.organizer.application.entity.GroupEntity;
import pl.home.organizer.application.model.request.GroupCreationRequestModel;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper( GroupMapper.class );

    GroupDto groupDetailsToGroupDto(GroupCreationRequestModel groupDetails);
    GroupEntity groupDtoToGroupEntity(GroupDto groupDto);
    GroupDto groupEntityToGroupDto(GroupEntity groupEntity);
}
