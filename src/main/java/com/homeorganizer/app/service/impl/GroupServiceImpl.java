package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.dto.GroupDto;
import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.UserEntity;
import com.homeorganizer.app.mapper.GroupMapper;
import com.homeorganizer.app.repository.GroupRepository;
import com.homeorganizer.app.repository.UserRepository;
import com.homeorganizer.app.service.GroupService;
import com.homeorganizer.app.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        GroupEntity groupEntity = GroupMapper.INSTANCE.groupDtoToGroupEntity(groupDto);
        groupEntity.setId(IdGenerator.generateUserId(10));

        groupRepository.save(groupEntity);

        return GroupMapper.INSTANCE.groupEntityToGroupDto(groupEntity);
    }
    @Override
    public GroupDto getGroupInfo(String groupId) {
        GroupEntity group = groupRepository.findGroupById(groupId);

        return GroupMapper.INSTANCE.groupEntityToGroupDto(group);
    }

    @Override
    public void addUserToGroup(String userId, String groupId) {
        GroupEntity group = groupRepository.findGroupById(groupId);
        UserEntity user = userRepository.findUserById(userId);

        group.addUser(user);

        groupRepository.save(group);
    }

    public void removeUserFromGroup(String userId, String groupId) {
        GroupEntity group = groupRepository.findGroupById(groupId);
        UserEntity user = userRepository.findUserById(userId);

        group.removeUser(user);

        groupRepository.save(group);
    }
}