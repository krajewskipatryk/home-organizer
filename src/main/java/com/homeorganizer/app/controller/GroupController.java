package com.homeorganizer.app.controller;

import com.homeorganizer.app.dto.GroupDto;
import com.homeorganizer.app.mapper.GroupMapper;
import com.homeorganizer.app.model.request.GroupCreationRequestModel;
import com.homeorganizer.app.model.request.UserInGroupRequestModel;
import com.homeorganizer.app.model.response.GroupRest;
import com.homeorganizer.app.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    GroupRest createGroup(@RequestBody GroupCreationRequestModel groupDetails) {
        return groupService.createGroup(groupDetails);
    }

    @GetMapping(path="{groupId}")
    GroupRest getGroupInfo(@PathVariable String groupId) {
        return groupService.getGroupInfo(groupId);
    }

    @PutMapping(path="add/{groupId}/{userId}")
    String addUserToGroup(@PathVariable String userId, @PathVariable String groupId) {
        groupService.addUserToGroup(userId, groupId);
        return "User has been added to the group";
    }

    @PutMapping(path="remove/{groupId}/{userId}")
    String removeUserFromGroup(@PathVariable String userId, @PathVariable String groupId) {
        groupService.removeUserFromGroup(userId, groupId);
        return "User has been removed from group";
    }

}
