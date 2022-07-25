package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.UserEntity;
import com.homeorganizer.app.mapper.GroupMapper;
import com.homeorganizer.app.model.request.GroupCreationRequestModel;
import com.homeorganizer.app.model.response.GroupRest;
import com.homeorganizer.app.repository.GroupRepository;
import com.homeorganizer.app.service.GroupService;
import com.homeorganizer.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserService userService;
    private final GroupMapper groupMapper;

    @Override
    public GroupRest createGroup(GroupCreationRequestModel groupDetails) {
        GroupEntity groupEntity = groupMapper.groupDetailsToGroupEntity(groupDetails);
        groupEntity.setId(String.valueOf(UUID.randomUUID()));

        groupRepository.save(groupEntity);

        return groupMapper.groupEntityToGroupRest(groupEntity);
    }
    @Override
    public GroupRest getGroupInfo(String groupId) {
        GroupEntity group = groupRepository.findGroupById(groupId);

        return groupMapper.groupEntityToGroupRest(group);
    }

    @Override
    public GroupEntity getGroupEntity(String groupId) {
        return groupRepository.findGroupById(groupId);
    }

    @Override
    public void addUserToGroup(String userId, String groupId) {
        GroupEntity group = groupRepository.findGroupById(groupId);
        UserEntity user = userService.getUserEntityById(userId);

        group.addUser(user);

        groupRepository.save(group);
    }

    public void removeUserFromGroup(String userId, String groupId) {
        GroupEntity group = groupRepository.findGroupById(groupId);
        UserEntity user = userService.getUserEntityById(userId);

        group.removeUser(user);

        groupRepository.save(group);
    }
}