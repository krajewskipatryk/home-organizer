package com.homeorganizer.app.repository;

import com.homeorganizer.app.entity.BoughtProduct;
import com.homeorganizer.app.entity.GroupEntity;
import com.homeorganizer.app.entity.Product;
import com.homeorganizer.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtProductRepo extends JpaRepository<BoughtProduct, Long> {
     BoughtProduct findByProduct(Product product);
     BoughtProduct findByGroup(GroupEntity group);
     BoughtProduct findByUser(UserEntity user);
}
