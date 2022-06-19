package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.entity.GroupEntity;
import pl.home.organizer.application.entity.UserEntity;
import pl.home.organizer.application.entity.UsersGroupsJoinEntity;
import pl.home.organizer.application.repository.GroupRepository;
import pl.home.organizer.application.repository.UserRepository;
import pl.home.organizer.application.repository.UsersGroupsJoinRepository;
import pl.home.organizer.application.service.GroupService;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UsersGroupsJoinRepository joinedGroupRepository;
    private final UserRepository userRepository;

    @Override
    public void createGroup(String name) {
        GroupEntity groupEntity = new GroupEntity();

        groupEntity.setGroupName(name);
        groupEntity.setId("asdf");

        groupRepository.save(groupEntity);
    }

    @Override
    public void addUserToGroup(String userId, String groupId) {
        UserEntity user = userRepository.findById(userId);
        GroupEntity group = groupRepository.findById(groupId);

        UsersGroupsJoinEntity groupJoin = new UsersGroupsJoinEntity();
        groupJoin.setGroup(group);
        groupJoin.setUser(user);

        joinedGroupRepository.save(groupJoin);
    }
}