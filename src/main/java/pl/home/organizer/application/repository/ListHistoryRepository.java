package pl.home.organizer.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.home.organizer.application.entity.CleaningEntity;

@Repository
public interface ListHistoryRepository extends JpaRepository<CleaningEntity, Long> {

}
