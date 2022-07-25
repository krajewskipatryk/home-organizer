package com.homeorganizer.app.mapper;

import com.homeorganizer.app.dto.ProductDto;
import com.homeorganizer.app.entity.ProductEntity;
import com.homeorganizer.app.model.request.ProductDetailsRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto entityToDto(ProductEntity productEntity);
    ProductEntity dtoToEntity(ProductDto productDto);
    ProductEntity productDetailsToEntity(ProductDetailsRequestModel productDetails);
    ProductDto productDetailsToDto(ProductDetailsRequestModel productDetails);

}