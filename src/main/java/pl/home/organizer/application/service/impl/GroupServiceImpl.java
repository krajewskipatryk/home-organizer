package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.entity.GroupEntity;
import pl.home.organizer.application.repository.GroupRepository;
import pl.home.organizer.application.service.GroupService;
import pl.home.organizer.application.utils.IdGenerator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final IdGenerator idGenerator;

    @Override
    public void createGroup(String name) {
        GroupEntity groupEntity = new GroupEntity();

        groupEntity.setGroupName(name);
        groupEntity.setGroupId(idGenerator.generateUserId(15));

        groupRepository.save(groupEntity);
    }

    @Override
    public List<String> getUsersList(String groupId) {
        return null;
    }

    @Override
    public void addUserToGroup(String userId, String groupId) {

    }
}