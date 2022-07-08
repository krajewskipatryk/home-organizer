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

    @PostMapping(path = "create")
    GroupRest createGroup(@RequestBody GroupCreationRequestModel groupDetails) {
        GroupDto group = GroupMapper.INSTANCE.groupDetailsToGroupDto(groupDetails);

        GroupDto returnValue = groupService.createGroup(group);
        return GroupMapper.INSTANCE.groupDtoToGroupRest(returnValue);
    }

    @GetMapping(path = "group/{groupId}")
    GroupRest getGroupInfo(@PathVariable String groupId) {
        GroupDto groupDto = groupService.getGroupInfo(groupId);
        return GroupMapper.INSTANCE.groupDtoToGroupRest(groupDto);
    }

    @PutMapping(path="add/{groupId}")
    String addUserToGroup(@RequestBody UserInGroupRequestModel user, @PathVariable String groupId) {
        groupService.addUserToGroup(user.getUserId(), groupId);
        return "User has been added to the group";
    }

    @PutMapping(path="remove/{groupId}")
    String removeUserFromGroup(@RequestBody UserInGroupRequestModel user, @PathVariable String groupId) {
        groupService.removeUserFromGroup(user.getUserId(), groupId);
        return "User has been removed from group";
    }

}
