package com.homeorganizer.app.repository;

import com.homeorganizer.app.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findById(String id);
    ProductEntity findByProductName(String name);
}
