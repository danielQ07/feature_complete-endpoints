package com.storeApp.productservice.repository;

import com.storeApp.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product findByProductCode(String productCode);
}
