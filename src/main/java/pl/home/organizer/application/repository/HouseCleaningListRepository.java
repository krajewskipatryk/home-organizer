package pl.home.organizer.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.home.organizer.application.entity.HouseCleaningListEntity;

@Repository
public interface HouseCleaningListRepository extends JpaRepository<HouseCleaningListEntity, Long> {

}
