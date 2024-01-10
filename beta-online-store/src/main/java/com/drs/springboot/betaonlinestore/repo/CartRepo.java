package com.drs.springboot.betaonlinestore.repo;

import com.drs.springboot.betaonlinestore.dao.Cart;
import com.drs.springboot.betaonlinestore.dao.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

    @Modifying
    @Query(
            nativeQuery = true,
            value = "INSERT INTO CART(CART_ID,USER_ID,PRODUCT_ID,QUANTITY) VALUES (:id,:userId,:productId,:quantity)"
    )
    @Transactional
    void insertToCart(@Param("id") long id,
                                @Param("userId") long userId,
                                @Param("productId") long productId,
                                @Param("quantity") int qty);

    @Modifying
    @Query(
            nativeQuery = true,
            value = " DELETE CART WHERE CART_ID = :id"
    )
    @Transactional
    void deleteCart(@Param("id") long id);

    @Modifying
    @Query(
            nativeQuery = true,
            value = " UPDATE CART SET QUANTITY = :quantity WHERE CART_ID = :id"
    )
    @Transactional
    void updateQuantity(@Param("quantity") int quantity,
                        @Param("id") long id);

    @Modifying
    @Query(
            nativeQuery = true,
            value = " DELETE CART WHERE USER_ID = :id"
    )
    @Transactional
    void removeAll(@Param("id") long id);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM CART WHERE USER_ID = :id"
    )
    List<Cart> retrieveAllCart(@Param("id") long id);



}
