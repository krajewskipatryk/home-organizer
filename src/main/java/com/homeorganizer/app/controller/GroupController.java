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
@RequestMapping("group")
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @PostMapping
    GroupRest createGroup(@RequestBody GroupCreationRequestModel groupDetails) {
        GroupDto group = groupMapper.groupDetailsToGroupDto(groupDetails);

        GroupDto returnValue = groupService.createGroup(group);
        return groupMapper.groupDtoToGroupRest(returnValue);
    }

    @PutMapping(path="group/{groupId}/user/{userId}")
    String addUserToGroup( @PathVariable String groupId, @PathVariable String userId) {
        groupService.addUserToGroup(groupId, userId);
        return "User has been added to the group";
    }
}
