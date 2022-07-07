package com.homeorganizer.app.repository;

import com.homeorganizer.app.entity.CleaningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListHistoryRepository extends JpaRepository<CleaningEntity, Long> {

}
