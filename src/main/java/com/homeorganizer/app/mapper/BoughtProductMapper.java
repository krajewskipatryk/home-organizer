package com.homeorganizer.app.mapper;


import com.homeorganizer.app.dto.BoughtProductDto;
import com.homeorganizer.app.entity.BoughtProductEntity;
import com.homeorganizer.app.model.response.BoughtProductRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoughtProductMapper {
    BoughtProductEntity dtoToEntity(BoughtProductDto boughtProductDto);
    BoughtProductRest entityToRest(BoughtProductEntity boughtProductEntity);
}
