package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.entity.CleaningEntity;
import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.UserEntity;
import com.homeorganizer.app.repository.CleaningRepository;
import com.homeorganizer.app.repository.GroupRepository;
import com.homeorganizer.app.repository.UserRepository;
import com.homeorganizer.app.service.CleaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CleaningServiceImpl implements CleaningService {
    private final CleaningRepository cleaningRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;


    @Override
    public void assignGroup(String groupId) {
        GroupEntity group = groupRepository.findGroupById(groupId);

        if ( groupRepository.findGroupById(groupId) == null ) throw new RuntimeException("The group does not exist in database!");
        if ( cleaningRepository.findByAssignedGroup(group) != null ) throw new RuntimeException("The group is already assigned to other cleaning functionality!");

        CleaningEntity cleaning = new CleaningEntity();
        cleaning.setAssignedGroup(group);

        cleaning.setNextCleaningDate(LocalDate.now().plusDays(7));

        cleaningRepository.save(cleaning);
    }

    @Override
    public void removeCleaningRecord(Long id) {
        CleaningEntity cleaningEntity = cleaningRepository.findCleaningById(id);
        cleaningRepository.delete(cleaningEntity);
    }

    @Override
    public void approveCleaning(String groupId, String userId) {
        GroupEntity group = groupRepository.findGroupById(groupId);
        UserEntity user = userRepository.findUserById(userId);

        if ( groupRepository.findGroupById(groupId) == null ) throw new RuntimeException("The group does not exist in database!");
        if ( cleaningRepository.findByAssignedGroup(group) == null ) throw new RuntimeException("The group has not been assigned to the cleaning functionality!");
        if ( !(group.getUsers().contains(user)) ) throw new RuntimeException("The user is not in the group!");

        CleaningEntity cleaning = cleaningRepository.findByAssignedGroup(group);
        cleaning.setLastCleaningDate(LocalDate.now());
        cleaning.setNextCleaningDate(LocalDate.now().plusDays(7));

        cleaning.setRecentlyCleaningUser(user);

        int index = group.getUsers().indexOf(user);

        if (group.getUsers().size() == index + 1) {
            cleaning.setNextCleaningUser(group.getUsers().get(0));
        } else {
            cleaning.setNextCleaningUser(group.getUsers().get(index + 1));
        }

        cleaningRepository.save(cleaning);
    }



}
