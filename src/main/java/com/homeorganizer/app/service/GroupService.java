package com.homeorganizer.app.service;

import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.model.request.GroupCreationRequestModel;
import com.homeorganizer.app.model.response.GroupRest;

public interface GroupService {
    GroupRest createGroup(GroupCreationRequestModel groupDetails);
    GroupRest getGroupInfo(String groupId);
    GroupEntity getGroupEntity(String groupId);
    void addUserToGroup(String userId, String groupId);
    void removeUserFromGroup(String userId, String groupId);

}
