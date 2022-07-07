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
    private final GroupMapper groupMapper;

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        GroupEntity groupEntity = groupMapper.groupDtoToGroupEntity(groupDto);
        groupEntity.setId(IdGenerator.generateUserId(10));

        groupRepository.save(groupEntity);
        return groupMapper.groupEntityToGroupDto(groupEntity);
    }

    @Override
    public void addUserToGroup(String userId, String groupId) {
        UserEntity user = userRepository.findById(userId);
        GroupEntity group = groupRepository.findById(groupId);

        group.addUser(user);
        user.addGroup(group);

        groupRepository.save(group);
//        userRepository.save(user);
    }
}