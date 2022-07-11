package com.homeorganizer.app.repository;

import com.homeorganizer.app.entity.CleaningEntity;
import com.homeorganizer.app.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CleaningRepository extends JpaRepository<CleaningEntity, Long> {
    CleaningEntity findByAssignedGroup(GroupEntity group);
    CleaningEntity findCleaningById(Long id);
}
