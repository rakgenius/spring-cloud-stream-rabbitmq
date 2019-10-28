package com.rakeshv.cloudstreamrabbitmqconsumer.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

/**
 * HelloListener
 */
@EnableBinding(HelloBinding.class)
@Slf4j
public class HelloListener {
    @StreamListener(target = HelloBinding.GREETING)
    public void processHelloGreeting(String message) {
        log.info("Received message: {}", message);
    }
    
}