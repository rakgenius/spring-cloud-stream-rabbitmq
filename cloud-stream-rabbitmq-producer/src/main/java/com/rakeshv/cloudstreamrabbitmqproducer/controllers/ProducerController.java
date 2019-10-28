package com.rakeshv.cloudstreamrabbitmqproducer.controllers;

import com.rakeshv.cloudstreamrabbitmqproducer.config.HelloBinding;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.support.MessageBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * ProducerController
 */
@RestController
@Slf4j
public class ProducerController {
    private MessageChannel messageChannel;

    public ProducerController(HelloBinding binding) {
        this.messageChannel = binding.greeting();
    }
    
    @GetMapping("/greet/{name}")
    public void publish(@PathVariable("name") final String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello " + name + " !. Welcome to rabbitmq");
        log.info("Sending the message {}", sb);
        Message<String> message = MessageBuilder.withPayload(sb.toString()).build();
        this.messageChannel.send(message);
    }
}