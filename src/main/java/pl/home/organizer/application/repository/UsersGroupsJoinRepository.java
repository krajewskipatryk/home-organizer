package pl.home.organizer.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.home.organizer.application.entity.UsersGroupsJoinEntity;

public interface UsersGroupsJoinRepository extends JpaRepository<UsersGroupsJoinEntity, Long> {

}
