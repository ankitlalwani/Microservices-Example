package com.microservices1.currencycalculationservice.bean;

import java.math.BigDecimal;

public class CalculatedAmount {
    private Long id;
    private String from;
    private String to;
    private int port;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;


    public CalculatedAmount(){

    }
    public CalculatedAmount(Long id, String from, String to, int port, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalculatedAmount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.port = port;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BigDecimal getconversionMultiple() {
        return conversionMultiple;
    }

    public void setconversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
}
