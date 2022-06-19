package pl.home.organizer.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.home.organizer.application.entity.CleaningListHistoryEntity;

@Repository
public interface ListHistoryRepository extends JpaRepository<CleaningListHistoryEntity, Long> {

}
