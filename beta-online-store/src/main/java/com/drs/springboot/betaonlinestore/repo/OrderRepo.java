package com.drs.springboot.betaonlinestore.repo;

import com.drs.springboot.betaonlinestore.dao.OrderDetail;
import com.drs.springboot.betaonlinestore.dao.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetail,Long> {

    @Modifying
    @Query(
            nativeQuery = true,
            value = "INSERT INTO ORDER_DETAIL(ORDER_ID,USER_ID,STATUS,TOTAL) VALUES (:id,:userId,:status,:total)"
    )
    @Transactional
    void makeOrder(@Param("id") long id,
                   @Param("userId") long userId,
                   @Param("status") int status,
                   @Param("total") int total);

    @Query(
            nativeQuery = true,
            value = "SELECT SUM(PRICE * QUANTITY) FROM CART AS A INNER JOIN PRODUCT AS B ON A.PRODUCT_ID = B.ID WHERE A.USER_ID=:userId"
    )
    int getTotalPrice(@Param("userId") long userId);

    @Modifying
    @Query(
            nativeQuery = true,
            value = " DELETE ORDER_DETAIL WHERE ORDER_ID = :id"
    )
    @Transactional
    void deleteOrder(@Param("id") long id);

}
