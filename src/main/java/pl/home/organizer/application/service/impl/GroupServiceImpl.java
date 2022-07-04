package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.dto.GroupDto;
import pl.home.organizer.application.entity.GroupEntity;
import pl.home.organizer.application.entity.UserEntity;
import pl.home.organizer.application.mapper.GroupMapper;
import pl.home.organizer.application.repository.GroupRepository;
import pl.home.organizer.application.repository.UserRepository;
import pl.home.organizer.application.service.GroupService;
import pl.home.organizer.application.utils.IdGenerator;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    @Autowired
    public GroupRepository groupRepository;
    @Autowired
    public UserRepository userRepository;

    @Override
    public void createGroup(GroupDto groupDto) {
        GroupEntity groupEntity;
        groupEntity = GroupMapper.INSTANCE.groupDtoToGroupEntity(groupDto);
        groupEntity.setId(IdGenerator.generateUserId(10));

        groupRepository.save(groupEntity);
    }

    @Override
    public void addUserToGroup(String userId, String groupId) {
        UserEntity user = userRepository.findById(userId);
        GroupEntity group = groupRepository.findById(groupId);

        group.addUser(user);
        user.addGroup(group);

        groupRepository.save(group);
    }
}