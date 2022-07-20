package com.homeorganizer.app.mapper;


import com.homeorganizer.app.dto.BoughtProductDto;
import com.homeorganizer.app.entity.BoughtProduct;
import com.homeorganizer.app.model.response.BoughtProductRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoughtProductMapper {
    BoughtProductMapper INSTANCE = Mappers.getMapper( BoughtProductMapper.class );

    BoughtProductDto productToDto(BoughtProduct boughtProduct);
    BoughtProduct dtoToProduct(BoughtProductDto boughtProductDto);

    @Mapping(target = "product", source = "product")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "group", source = "group")
    BoughtProductRest dtoToRest(BoughtProductDto boughtProductDto);
}
