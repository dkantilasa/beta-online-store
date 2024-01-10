package com.drs.springboot.betaonlinestore.dto;

import java.math.BigDecimal;

public class CurrencyConversion {
    private long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversion;
    private BigDecimal totalCalculatedAmount;

    public CurrencyConversion(){};

    public CurrencyConversion(long id, String from, String to, BigDecimal quantity, BigDecimal conversion, BigDecimal totalCalculatedAmount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.conversion = conversion;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getConversion() {
        return conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
}
