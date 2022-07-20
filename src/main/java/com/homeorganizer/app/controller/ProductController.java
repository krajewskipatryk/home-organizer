package com.homeorganizer.app.controller;

import com.homeorganizer.app.dto.ProductDto;
import com.homeorganizer.app.mapper.ProductMapper;
import com.homeorganizer.app.model.request.ProductDetailsRequestModel;
import com.homeorganizer.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}")
    private ProductDto getProductById(@PathVariable long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping
    private ProductDto getProductByName(@RequestBody ProductDetailsRequestModel productDetails) {
        return productService.getProduct(productDetails.getProductName());
    }

    @PostMapping
    private ProductDto addProduct(@RequestBody ProductDetailsRequestModel productDetails) {
        return productService.addProduct(ProductMapper.INSTANCE.requestDetailsToDto(productDetails));
    }

    @DeleteMapping("/{productId}")
    private ProductDto deleteProductById(@PathVariable long productId) {
        return productService.deleteProduct(productId);
    }

    @DeleteMapping
    private ProductDto deleteProductByName(@RequestBody ProductDetailsRequestModel productDetails) {
        return productService.deleteProduct(productDetails.getProductName());
    }

    @PutMapping("/productId")
    private ProductDto updateProduct(@PathVariable long productId, @RequestBody ProductDetailsRequestModel productDetails) {
        return productService.updateProduct(productId, ProductMapper.INSTANCE.requestDetailsToDto(productDetails));
    }
}
