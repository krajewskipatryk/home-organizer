package com.homeorganizer.app.dto;

import com.homeorganizer.app.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GroupDto {
    private String id;
    private String groupName;
    private List<UserEntity> users = new ArrayList<>();
}
