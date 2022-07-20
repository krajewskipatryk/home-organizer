package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.entity.BoughtProduct;
import com.homeorganizer.app.repository.BoughtProductRepo;
import com.homeorganizer.app.repository.GroupRepository;
import com.homeorganizer.app.repository.ProductRepo;
import com.homeorganizer.app.repository.ShoppingListRepo;
import com.homeorganizer.app.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingListServiceImpl implements ShoppingListService {
    private final ShoppingListRepo shoppingListRepo;
    private final GroupRepository groupRepository;
    private final ProductRepo productRepo;
    private final BoughtProductRepo boughtProductRepo;

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
    public void addBoughtProduct(long id, BoughtProduct boughtProduct) {

    }
}
