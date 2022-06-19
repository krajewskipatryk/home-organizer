package pl.home.organizer.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pl.home.organizer.application.dto.GroupDto;
import pl.home.organizer.application.model.request.GroupCreationRequestModel;
import pl.home.organizer.application.model.request.UserToGroupRequestModel;
import pl.home.organizer.application.service.GroupService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("group")
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    String createGroup(@RequestBody GroupCreationRequestModel groupDetails) {
        GroupDto house = new GroupDto();

        BeanUtils.copyProperties(groupDetails, house);

        groupService.createGroup(house.getGroupName());

        return "Group has been created correctly";
    }

    @GetMapping(path="/{groupId}")
    List<String> getUsersList(@PathVariable String groupId) {
        return groupService.getUsersList(groupId);
    }

    @PutMapping(path="/{groupId}")
    String addUserToGroup(@RequestBody UserToGroupRequestModel userDetails, @PathVariable String groupId) {
        groupService.addUserToGroup(userDetails.getUserId(), groupId);
        return "User has been added to the group";
    }
}
