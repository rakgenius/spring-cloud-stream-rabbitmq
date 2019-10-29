package com.rakeshv.cloudstreamrabbitmqproducer.controllers;

import java.util.Date;

import com.rakeshv.cloudstreamrabbitmqproducer.config.CustomMessageBinding;
import com.rakeshv.cloudstreamrabbitmqproducer.config.HelloBinding;
import com.rakeshv.cloudstreamrabbitmqproducer.config.UserMessageBinding;
import com.rakeshv.cloudstreamrabbitmqproducer.models.CustomMessage;
import com.rakeshv.userviewdto.model.UserView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * ProducerController
 */
@RestController
@Slf4j
public class ProducerController {
    @Autowired
    CustomMessageBinding customMessageBinding;
    @Autowired
    HelloBinding helloBinding;
    @Autowired
    UserMessageBinding userMessageBinding;

    @GetMapping("/greet/{name}")
    public void publish(@PathVariable("name") final String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello " + name + " !. Welcome to rabbitmq");
        log.info("Sending the message {}", sb);
        Message<String> message = MessageBuilder.withPayload(sb.toString()).build();
        helloBinding.greeting().send(message);
    }

    @GetMapping("/publish/{name}")
    public void publishMessage(@PathVariable("name") final String name) {
        CustomMessage message = CustomMessage.builder()
                                        .message("Hello " + name)
                                        .date(new Date()).build();
        log.info("sending message : {}", message.toString());
        Message<CustomMessage> cMessage = MessageBuilder.withPayload(message).build();
        customMessageBinding.customMessage().send(cMessage);
    }

    @GetMapping("/user")
    public void publishUserView() {
        UserView userView = UserView.builder()
                                .firstName("Rakesh")
                                .lastName("v")
                                .age(10)
                                .location("Amsterdam")
                                .nationality("Indian")
                                .organization("Open source")
                                .build();
        log.info("Sending message : {}", userView);
        Message<UserView> message = MessageBuilder.withPayload(userView).build();
        userMessageBinding.publishUserView().send(message);
    }
}