package com.homeorganizer.app.model.response;

import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.ProductEntity;
import com.homeorganizer.app.entity.UserEntity;
import lombok.Data;

@Data
public class BoughtProductRest {
    private ProductEntity product;
    private UserEntity user;
    private GroupEntity group;
}
