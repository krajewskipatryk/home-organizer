package com.homeorganizer.app.repository;

import com.homeorganizer.app.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepo extends JpaRepository<ShoppingList, Long> {
    ShoppingList findById(long id);
}
