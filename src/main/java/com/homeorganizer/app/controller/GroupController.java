package com.homeorganizer.app.controller;

import com.homeorganizer.app.dto.GroupDto;
import com.homeorganizer.app.mapper.GroupMapper;
import com.homeorganizer.app.model.request.GroupCreationRequestModel;
import com.homeorganizer.app.model.response.GroupRest;
import com.homeorganizer.app.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GroupController {
    private final GroupService groupService;

    @PostMapping(path="group")
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

    @PutMapping(path="group/{groupId}/user/{userId}")
    String addUserToGroup( @PathVariable String groupId, @PathVariable String userId) {
        groupService.addUserToGroup(userId, groupId);
        return "User has been added to the group";
    }
}
