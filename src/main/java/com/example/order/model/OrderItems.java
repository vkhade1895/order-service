package com.example.order.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;
    private String productName;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    // No-argument constructor
    public OrderItems() {
        // CHANGE: Required by JPA
    }

    public OrderItems(Long item_id, String productName, int quantity, double price, Order order) {
        this.item_id = item_id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public Long getItem_id() {
        return item_id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Order getOrder() {
        return order;
    }
}
