package com.rakeshv.cloudstreamrabbitmqconsumer.subscriber;

import com.rakeshv.cloudstreamrabbitmqconsumer.models.CustomeMessage;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomMessageListener
 */
@EnableBinding(SubscriberBinding.class)
@Slf4j
public class CustomMessageListener {

    @StreamListener(target = SubscriberBinding.QUEUE)
    public void processCustomMessage(CustomeMessage message) {
        log.info("Received message: {}", message);  
    }
}