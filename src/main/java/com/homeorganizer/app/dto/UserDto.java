package com.homeorganizer.app.dto;

import com.homeorganizer.app.entity.GroupEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<GroupEntity> groups = new ArrayList<>();
}