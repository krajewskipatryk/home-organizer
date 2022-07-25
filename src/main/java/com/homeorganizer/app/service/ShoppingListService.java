package com.homeorganizer.app.service;

import com.homeorganizer.app.entity.BoughtProductEntity;

public interface ShoppingListService {
    void assignGroup(long id, String groupId);
    void addProduct(String groupId, String productName);
    void removeProduct(String groupId, String productName);
    void addBoughtProduct(long id, BoughtProductEntity boughtProductEntity);

}
