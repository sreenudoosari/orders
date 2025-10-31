package com.myapp.orders.dto;

import java.util.List;

public class Order {
    private String orderId;
    private String customerId;
    private List<ProductItem> items;
    private double total;

    // Constructors
    public Order() {}

    public Order(String orderId, String customerId, List<ProductItem> items, double total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.total = total;
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<ProductItem> getItems() {
        return items;
    }

    public void setItems(List<ProductItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
