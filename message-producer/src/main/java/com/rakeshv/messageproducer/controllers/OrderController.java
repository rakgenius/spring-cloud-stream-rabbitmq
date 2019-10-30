package com.rakeshv.messageproducer.controllers;

import com.rakeshv.messageproducer.model.Order;
import com.rakeshv.messageproducer.service.OrderMessageSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


/**
 * OrderController
 */
@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderMessageSender orderMessageSender;

    @GetMapping
    public void sendOrder() {
        Order order = Order.builder()
                            .amount(1000)
                            .orderNumber("500")
                            .productId("545").build();
        log.info("Sending the order: {}", order.toString());
        orderMessageSender.sendOrder(order);
    }
    
}