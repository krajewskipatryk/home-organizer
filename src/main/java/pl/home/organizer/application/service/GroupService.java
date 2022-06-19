package pl.home.organizer.application.service;

public interface GroupService {
    void createGroup(String name);
    void addUserToGroup(String userId, String groupId);
}
