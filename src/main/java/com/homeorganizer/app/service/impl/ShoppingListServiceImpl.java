package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.entity.BoughtProductEntity;
import com.homeorganizer.app.repository.BoughtProductRepository;
import com.homeorganizer.app.repository.GroupRepository;
import com.homeorganizer.app.repository.ProductRepository;
import com.homeorganizer.app.repository.ShoppingListRepository;
import com.homeorganizer.app.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingListServiceImpl implements ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    private final GroupRepository groupRepository;
    private final ProductRepository productRepository;
    private final BoughtProductRepository boughtProductRepository;

    @Override
    public void assignGroup(long id, String groupId) {

    }

    @Override
    public void addProduct(String groupId, String productName) {

    }

    @Override
    public void removeProduct(String groupId, String productName) {

    }

    @Override
    public void addBoughtProduct(long id, BoughtProductEntity boughtProductEntity) {

    }
}
