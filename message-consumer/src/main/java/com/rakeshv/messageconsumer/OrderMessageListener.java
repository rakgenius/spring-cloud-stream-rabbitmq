package com.rakeshv.messageconsumer;

import com.rakeshv.messageconsumer.config.RabbitmqConfig;
import com.rakeshv.messageconsumer.model.Order;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * OrderMessageListener
 */
@Component
@Slf4j
public class OrderMessageListener {
    @RabbitListener(queues = RabbitmqConfig.QUEUE_ORDERS)
    public void processOrder(Order order) {
        log.info("Order received: {}", order);
    }
    
}