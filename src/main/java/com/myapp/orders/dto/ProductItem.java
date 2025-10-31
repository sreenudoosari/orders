package com.myapp.orders.dto;

public class ProductItem {
    private String productId;
    private int quantity;

    // Constructors
    public ProductItem() {}

    public ProductItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
