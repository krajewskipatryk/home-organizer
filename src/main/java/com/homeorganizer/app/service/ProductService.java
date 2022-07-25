package com.homeorganizer.app.service;

import com.homeorganizer.app.dto.ProductDto;
import com.homeorganizer.app.entity.ProductEntity;
import com.homeorganizer.app.model.request.ProductDetailsRequestModel;

public interface ProductService {
    ProductDto getProduct(String id);
    ProductEntity getProductEntity(String productId);
    ProductDto addProduct(ProductDetailsRequestModel productDetails);
    ProductDto deleteProduct(String id);
    ProductDto updateProduct(String id, ProductDetailsRequestModel productDetails) throws Exception;
}
