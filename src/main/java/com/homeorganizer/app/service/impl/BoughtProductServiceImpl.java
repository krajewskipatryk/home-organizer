package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.dto.BoughtProductDto;
import com.homeorganizer.app.entity.BoughtProductEntity;
import com.homeorganizer.app.mapper.BoughtProductMapper;
import com.homeorganizer.app.model.response.BoughtProductRest;
import com.homeorganizer.app.repository.BoughtProductRepository;
import com.homeorganizer.app.service.BoughtProductService;
import com.homeorganizer.app.service.GroupService;
import com.homeorganizer.app.service.ProductService;
import com.homeorganizer.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoughtProductServiceImpl implements BoughtProductService {
    private final BoughtProductRepository boughtProductRepository;
    private final UserService userService;
    private final GroupService groupService;
    private final ProductService productService;
    private final BoughtProductMapper boughtProductMapper;


    @Override
    public BoughtProductRest addBoughtProduct(String groupId, String userId, String productName) {
        BoughtProductDto boughtProductDto = new BoughtProductDto();
        boughtProductDto.setUser(userService.getUserEntityById(userId));
        boughtProductDto.setGroup(groupService.getGroupEntity(groupId));
        boughtProductDto.setProduct(productService.getProductEntity(productName));

        BoughtProductEntity boughtProductEntity = boughtProductMapper.dtoToEntity(boughtProductDto);

        boughtProductRepository.save(boughtProductEntity);

        return boughtProductMapper.entityToRest(boughtProductEntity);
    }

    @Override
    public List<BoughtProductRest> getBoughtProducts(String groupId) {
        return null;
    }

    @Override
    public List<BoughtProductRest> getBoughtProducts(String groupId, String userId) {
        return null;
    }

    @Override
    public List<BoughtProductRest> getBoughtProducts(String groupId, String userId, String productName) {
        return null;
    }
}
