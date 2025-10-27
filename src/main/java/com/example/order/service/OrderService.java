package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.model.OrderItems;
import com.example.order.model.OrderStatuses;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        for (OrderItems item : order.getOrderItemsList()) {
            item.setOrder(order);
        }
        return orderRepository.save(order);
    }

    public void updateOrderStatus() {
        List<Order> status = orderRepository.findByOrderStatus(OrderStatuses.PENDING);
        status.forEach(e -> {
            e.setOrderStatus(OrderStatuses.PROCESSING);
            orderRepository.save(e);
        });
        System.out.println("successful updated");

    }

    public Order cancelOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID not found" + id));

        if(order.getOrderStatus() != OrderStatuses.PENDING){
            throw new RuntimeException("Cannot cancel order "+ order.getOrderStatus().name());
        }
        order.setOrderStatus(OrderStatuses.CANCELLED);
        orderRepository.save(order);
        return order;
    }

    public Order updateOrderStatusFromUser(Long id, OrderStatuses orderStatuses) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID not found" + id));
        order.setOrderStatus(orderStatuses);
        orderRepository.save(order);
        return order;
    }
}
