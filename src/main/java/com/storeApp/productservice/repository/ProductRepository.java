package com.storeApp.productservice.repository;

import com.storeApp.productservice.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product findByProductCode(String productCode);

    @Transactional
    @Modifying
    public void deleteByProductCode(String productCode);
}
