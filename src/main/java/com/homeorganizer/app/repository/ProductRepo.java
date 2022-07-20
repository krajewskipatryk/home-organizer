package com.homeorganizer.app.repository;

import com.homeorganizer.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findById(long id);
    Product findByProductName(String name);
}
