package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping
    public List<Order> getAllOrders(){
       return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Long id){
        return orderService.getOrder(id);
    }

}
