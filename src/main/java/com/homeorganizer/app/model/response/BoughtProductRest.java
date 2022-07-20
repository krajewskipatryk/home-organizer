package com.homeorganizer.app.model.response;

import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.Product;
import com.homeorganizer.app.entity.UserEntity;
import lombok.Data;

@Data
public class BoughtProductRest {
    private Product product;
    private UserEntity user;
    private GroupEntity group;
}
