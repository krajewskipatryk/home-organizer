package com.homeorganizer.app.service;

import com.homeorganizer.app.dto.BoughtProductDto;
import com.homeorganizer.app.entity.BoughtProduct;

import java.util.List;

public interface BoughtProductService {
    BoughtProductDto addBoughtProduct(String groupId, String userId, String productName);
    List<BoughtProduct> getBoughtProducts(String groupId);
    List<BoughtProduct> getBoughtProducts(String groupId, String userId);
    List<BoughtProduct> getBoughtProducts(String groupId, String userId, String productName);
}
