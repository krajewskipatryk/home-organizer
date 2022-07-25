package com.homeorganizer.app.service;

import com.homeorganizer.app.dto.BoughtProductDto;
import com.homeorganizer.app.entity.BoughtProductEntity;
import com.homeorganizer.app.model.response.BoughtProductRest;

import java.util.List;

public interface BoughtProductService {
    BoughtProductRest addBoughtProduct(String groupId, String userId, String productName);
    List<BoughtProductRest> getBoughtProducts(String groupId);
    List<BoughtProductRest> getBoughtProducts(String groupId, String userId);
    List<BoughtProductRest> getBoughtProducts(String groupId, String userId, String productName);
}
