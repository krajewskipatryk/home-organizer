package com.homeorganizer.app.repository;

import com.homeorganizer.app.entity.BoughtProductEntity;
import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.ProductEntity;
import com.homeorganizer.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtProductRepository extends JpaRepository<BoughtProductEntity, Long> {
     BoughtProductEntity findByProduct(ProductEntity productEntity);
     BoughtProductEntity findByGroup(GroupEntity group);
     BoughtProductEntity findByUser(UserEntity user);
}
