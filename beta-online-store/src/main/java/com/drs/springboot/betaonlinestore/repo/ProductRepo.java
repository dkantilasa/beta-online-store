package com.drs.springboot.betaonlinestore.repo;

import com.drs.springboot.betaonlinestore.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM PRODUCT"
    )
    List<Product> getAllProduct();

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM PRODUCT WHERE ID = :id"
    )
    List<Product> getProductById(@Param("id")long id);
}
