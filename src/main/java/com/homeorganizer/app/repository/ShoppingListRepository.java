package com.homeorganizer.app.repository;

import com.homeorganizer.app.entity.ShoppingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity, Long> {
    ShoppingListEntity findById(long id);
}
