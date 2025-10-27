package com.example.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderScheduler {

    @Autowired
    OrderService orderService;

    @Scheduled(fixedRate = 300000)
    public void updateRecord(){
        System.out.println("scheduler called");
        orderService.updateOrderStatus();
    }
}
