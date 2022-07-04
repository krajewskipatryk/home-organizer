package pl.home.organizer.application.service;

import pl.home.organizer.application.dto.GroupDto;

public interface GroupService {
    void createGroup(GroupDto groupDto);
    void addUserToGroup(String userId, String groupId);
}
