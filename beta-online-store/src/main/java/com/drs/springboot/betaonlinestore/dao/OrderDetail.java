package com.drs.springboot.betaonlinestore.dao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderDetail {

    @Id
    @Column(name = "orderId")
    private long orderId;

    @Column(name = "userId")
    private long userId;

    @Column(name = "status")
    private String status;

    @Column(name = "total")
    private int total;

    public OrderDetail() {

    }

    public OrderDetail(long id, long userId, String status, int total) {
        this.userId = id;
        this.userId = userId;
        this.status = status;
        this.total = total;
    }

    public long getId() {
        return userId;
    }

    public void setId(long id) {
        this.userId = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}