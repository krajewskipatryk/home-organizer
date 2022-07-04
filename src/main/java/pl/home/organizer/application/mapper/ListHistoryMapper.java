package pl.home.organizer.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.home.organizer.application.dto.HouseCleanerDto;
import pl.home.organizer.application.entity.CleaningEntity;
import pl.home.organizer.application.model.request.CleanerDetailsRequestModel;

@Mapper(componentModel = "spring")
public interface ListHistoryMapper {
    ListHistoryMapper INSTANCE = Mappers.getMapper( ListHistoryMapper.class );

    HouseCleanerDto cleanerDetailsToCleanerDto(CleanerDetailsRequestModel cleanerDetails);
    CleaningEntity cleanerDtoToCleanerEntity(HouseCleanerDto cleanerDto);
    HouseCleanerDto cleanerEntityToCleanerDto(CleaningEntity cleaningEntity);
}
