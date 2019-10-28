package com.rakeshv.cloudstreamrabbitmqproducer.controllers;

import java.util.Date;

import com.rakeshv.cloudstreamrabbitmqproducer.config.CustomMessageBinding;
import com.rakeshv.cloudstreamrabbitmqproducer.config.HelloBinding;
import com.rakeshv.cloudstreamrabbitmqproducer.models.CustomMessage;

import org.springframework.beans.factory.annotation.Autowired;
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
    private MessageChannel custoMessageChannel;

    @Autowired
    public ProducerController(HelloBinding binding, CustomMessageBinding customMessageBinding) {
        this.messageChannel = binding.greeting();
        this.custoMessageChannel = customMessageBinding.customMessage();
    }
    
    @GetMapping("/greet/{name}")
    public void publish(@PathVariable("name") final String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello " + name + " !. Welcome to rabbitmq");
        log.info("Sending the message {}", sb);
        Message<String> message = MessageBuilder.withPayload(sb.toString()).build();
        this.messageChannel.send(message);
    }

    @GetMapping("/publish/{name}")
    public void publishMessage(@PathVariable("name") final String name) {
        CustomMessage message = CustomMessage.builder()
                                        .message("Hello " + name)
                                        .date(new Date()).build();
        log.info("sending message : {}", message.toString());
        Message<CustomMessage> cMessage = MessageBuilder.withPayload(message).build();
        this.custoMessageChannel.send(cMessage);
    }
}