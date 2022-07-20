package com.homeorganizer.app.dto;

import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.Product;
import com.homeorganizer.app.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoughtProductDto {
    private long id;
    private Product product;
    private UserEntity user;
    private GroupEntity group;
}
