package com.homeorganizer.app.controller;

import com.homeorganizer.app.dto.ProductDto;
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
    private ProductDto getProductById(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    private ProductDto addProduct(@RequestBody ProductDetailsRequestModel productDetails) {
        return productService.addProduct(productDetails);
    }

    @DeleteMapping("/{productId}")
    private ProductDto deleteProductById(@PathVariable String productId) {
        return productService.deleteProduct(productId);
    }

    @PutMapping("/update/{productId}")
    private ProductDto updateProduct(@PathVariable String productId, @RequestBody ProductDetailsRequestModel productDetails) throws Exception {
        return productService.updateProduct(productId, productDetails);
    }
}
