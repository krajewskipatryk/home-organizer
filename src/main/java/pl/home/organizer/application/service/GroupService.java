package pl.home.organizer.application.service;

import pl.home.organizer.application.dto.GroupDto;

import java.util.List;

public interface GroupService {
    void createGroup(String name);
    List<String> getUsersList(String groupId);
    void addUserToGroup(String userId, String groupId);
}
