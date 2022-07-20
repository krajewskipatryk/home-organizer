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

        CleaningEntity cleaning = new CleaningEntity();
        cleaning.setAssignedGroup(group);

        cleaning.setNextCleaningDate(LocalDate.now().plusDays(7));

        cleaningRepository.save(cleaning);
    }

    @Override
    public void deleteCleaning(Long id) {
        CleaningEntity cleaningEntity = cleaningRepository.findCleaningById(id);
        cleaningRepository.delete(cleaningEntity);
    }

    @Override
    public void approveCleaning(String groupId, String userId) {
        GroupEntity group = groupRepository.findGroupById(groupId);
        UserEntity user = userRepository.findUserById(userId);

        CleaningEntity cleaning = cleaningRepository.findByAssignedGroup(group);
        cleaning.setLastCleaningDate(LocalDate.now());
        cleaning.setNextCleaningDate(cleaning.getLastCleaningDate().plusDays(7));

        cleaning.setRecentlyCleaningUser(user);

        int index = group.getUsers().indexOf(user);

        if ( index + 1 == group.getUsers().size() ) {
            cleaning.setNextCleaningUser(group.getUsers().get(0));
        } else {
            cleaning.setNextCleaningUser(group.getUsers().get(index + 1));
        }

        cleaningRepository.save(cleaning);
    }
}
