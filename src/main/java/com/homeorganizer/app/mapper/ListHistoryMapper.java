package com.homeorganizer.app.mapper;

import com.homeorganizer.app.dto.HouseCleanerDto;
import com.homeorganizer.app.entity.CleaningEntity;
import com.homeorganizer.app.model.request.CleanerDetailsRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListHistoryMapper {
    ListHistoryMapper INSTANCE = Mappers.getMapper( ListHistoryMapper.class );

    HouseCleanerDto cleanerDetailsToCleanerDto(CleanerDetailsRequestModel cleanerDetails);
    CleaningEntity cleanerDtoToCleanerEntity(HouseCleanerDto cleanerDto);
    HouseCleanerDto cleanerEntityToCleanerDto(CleaningEntity cleaningEntity);
}
