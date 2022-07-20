package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.dto.BoughtProductDto;
import com.homeorganizer.app.entity.BoughtProduct;
import com.homeorganizer.app.mapper.BoughtProductMapper;
import com.homeorganizer.app.repository.BoughtProductRepo;
import com.homeorganizer.app.repository.GroupRepository;
import com.homeorganizer.app.repository.ProductRepo;
import com.homeorganizer.app.repository.UserRepository;
import com.homeorganizer.app.service.BoughtProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoughtProductServiceImpl implements BoughtProductService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final BoughtProductRepo boughtProductRepo;
    private final ProductRepo productRepo;

    @Override
    public BoughtProductDto addBoughtProduct(String groupId, String userId, String productName) {
        BoughtProduct boughtProduct = new BoughtProduct();
        boughtProduct.setUser(userRepository.findUserById(userId));
        boughtProduct.setGroup(groupRepository.findGroupById(groupId));
        boughtProduct.setProduct(productRepo.findByProductName(productName));

        boughtProductRepo.save(boughtProduct);

        return BoughtProductMapper.INSTANCE.productToDto(boughtProduct);
    }

    @Override
    public List<BoughtProduct> getBoughtProducts(String groupId) {
        return null;
    }

    @Override
    public List<BoughtProduct> getBoughtProducts(String groupId, String userId) {
        return null;
    }

    @Override
    public List<BoughtProduct> getBoughtProducts(String groupId, String userId, String productName) {
        return null;
    }
}
