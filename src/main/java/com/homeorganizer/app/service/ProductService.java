package com.homeorganizer.app.service;

import com.homeorganizer.app.dto.ProductDto;
import com.homeorganizer.app.entity.Product;

public interface ProductService {
    public ProductDto getProduct(long id);
    public ProductDto getProduct(String productName);
    public ProductDto addProduct(ProductDto product);
    public ProductDto deleteProduct(long id);
    public ProductDto deleteProduct(String productName);
    public ProductDto updateProduct(long id, ProductDto productDto);
}
