package com.homeorganizer.app.service;


import com.homeorganizer.app.dto.GroupDto;

public interface GroupService {
    GroupDto createGroup(GroupDto groupDto);
    void addUserToGroup(String userId, String groupId);
}
