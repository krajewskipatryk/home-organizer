package com.homeorganizer.app.mapper;

import com.homeorganizer.app.dto.ProductDto;
import com.homeorganizer.app.entity.Product;
import com.homeorganizer.app.model.request.ProductDetailsRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    Product dtoToEntity(ProductDto productDto);
    ProductDto entityToDto(Product product);
    @Mapping(target = "productName", source = "productName")
    ProductDto requestDetailsToDto(ProductDetailsRequestModel productDetails);
    @Mapping(target = "productName", source = "productName")
    Product requestDetailsToEntity(ProductDetailsRequestModel productDetails);
}
