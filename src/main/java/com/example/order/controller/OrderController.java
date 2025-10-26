package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order savedOrder=orderService.createOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

}
