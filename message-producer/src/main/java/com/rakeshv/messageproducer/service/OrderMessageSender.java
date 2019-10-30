package com.rakeshv.messageproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakeshv.messageproducer.config.RabbitmqConfig;
import com.rakeshv.messageproducer.model.Order;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * OrderMessageSender
 */
@Service
@Slf4j
public class OrderMessageSender {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public OrderMessageSender(RabbitTemplate template) {
        this.rabbitTemplate = template;
    }

    public void sendOrder(Order order) {
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_ORDERS, order);
    }
    
    public void sendOrderJson() {
        Order order = Order.builder()
                            .orderNumber("100")
                            .productId("200")
                            .amount(1000).build();
        try {
            String orderJson = mapper.writeValueAsString(order);
            Message message = MessageBuilder
                                    .withBody(orderJson.getBytes())
                                    .setContentType(MessageProperties.CONTENT_TYPE_JSON).build();
            this.rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_ORDERS, message);
        } catch (JsonProcessingException e) {
            log.error("{}", e.getMessage());
        }
    }
}