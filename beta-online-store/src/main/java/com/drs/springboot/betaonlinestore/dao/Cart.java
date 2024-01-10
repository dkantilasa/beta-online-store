package com.drs.springboot.betaonlinestore.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id
    @Column(name = "cartId")
    private long id;
    @Column(name = "userId")
    private long userId;
    @Column(name = "productId")
    private long productId;

    @Column(name = "quantity")
    private int qty;

    public Cart(){}

    public Cart(long id, long userId, long productId,int quantity) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.qty = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
