package com.example.order.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    @Enumerated(EnumType.STRING)
    private OrderStatuses orderStatus;
    private LocalDateTime localDateTime;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> orderItemsList;

    public Order() {
    }

    public Order(Long id, String customerName, OrderStatuses orderStatus, LocalDateTime localDateTime, List<OrderItems> orderItemsList) {
        this.id = id;
        this.customerName = customerName;
        this.orderStatus = orderStatus;
        this.localDateTime = localDateTime;
        this.orderItemsList = orderItemsList;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatuses getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }
}
