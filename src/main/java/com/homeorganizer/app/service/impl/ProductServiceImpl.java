package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.dto.ProductDto;
import com.homeorganizer.app.entity.Product;
import com.homeorganizer.app.mapper.ProductMapper;
import com.homeorganizer.app.repository.ProductRepo;
import com.homeorganizer.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public ProductDto getProduct(long id) {
        return ProductMapper.INSTANCE.entityToDto(productRepo.findById(id));
    }

    @Override
    public ProductDto getProduct(String productName) {
        return ProductMapper.INSTANCE.entityToDto(productRepo.findByProductName(productName));
    }

    @Override
    public ProductDto addProduct(ProductDto product) {
        productRepo.save(ProductMapper.INSTANCE.dtoToEntity(product));

        return product;
    }

    @Override
    public ProductDto deleteProduct(long id) {
        Product product = productRepo.findById(id);
        productRepo.delete(product);
        return ProductMapper.INSTANCE.entityToDto(product);
    }

    @Override
    public ProductDto deleteProduct(String productName) {
        Product product = productRepo.findByProductName(productName);
        productRepo.delete(product);
        return ProductMapper.INSTANCE.entityToDto(product);
    }

    @Override
    public ProductDto updateProduct(long id, ProductDto product) {
        productRepo.save(ProductMapper.INSTANCE.dtoToEntity(product));
        return product;
    }
}
