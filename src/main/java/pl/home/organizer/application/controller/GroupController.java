package pl.home.organizer.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.home.organizer.application.dto.GroupDto;
import pl.home.organizer.application.mapper.GroupMapper;
import pl.home.organizer.application.model.request.GroupCreationRequestModel;
import pl.home.organizer.application.service.GroupService;

@RequiredArgsConstructor
@RestController
@RequestMapping("group")
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    String createGroup(@RequestBody GroupCreationRequestModel groupDetails) {
        GroupDto group = GroupMapper.INSTANCE.groupDetailsToGroupDto(groupDetails);

        groupService.createGroup(group);

        return "Group has been created correctly";
    }

    @PutMapping(path="group/{groupId}/user/{userId}")
    String addUserToGroup( @PathVariable String groupId, @PathVariable String userId) {
        groupService.addUserToGroup(groupId, userId);
        return "User has been added to the group";
    }
}
