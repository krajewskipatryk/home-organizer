package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.dto.ProductDto;
import com.homeorganizer.app.entity.ProductEntity;
import com.homeorganizer.app.mapper.ProductMapper;
import com.homeorganizer.app.model.request.ProductDetailsRequestModel;
import com.homeorganizer.app.repository.ProductRepository;
import com.homeorganizer.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProduct(String id) {
        return productMapper.entityToDto(productRepository.findById(id));
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public ProductDto addProduct(ProductDetailsRequestModel productDetails) {
        ProductDto productDto = productMapper.productDetailsToDto(productDetails);
        productDto.setId(String.valueOf(UUID.randomUUID()));
        ProductEntity productEntity = productMapper.dtoToEntity(productDto);

        productRepository.save(productEntity);

        return productMapper.entityToDto(productEntity);
    }

    @Override
    public ProductDto deleteProduct(String id) {
        ProductEntity productEntity = productRepository.findById(id);
        productRepository.delete(productEntity);
        return productMapper.entityToDto(productEntity);
    }

    @Override
    public ProductDto updateProduct(String id, ProductDetailsRequestModel productDetails) throws Exception {
        if (productRepository.findById(id) == null) {
            throw new Exception("Product does not exist in database");
        }
        ProductDto productDto = productMapper.productDetailsToDto(productDetails);
        productDto.setId(id);

        ProductEntity productEntity = productMapper.dtoToEntity(productDto);

        productRepository.save(productEntity);

        return productMapper.entityToDto(productEntity);
    }
}
