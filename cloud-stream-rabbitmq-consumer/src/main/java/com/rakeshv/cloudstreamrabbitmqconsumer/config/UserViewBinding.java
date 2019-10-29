package com.rakeshv.cloudstreamrabbitmqconsumer.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * UserViewBinding
 */
public interface UserViewBinding {
    String USERVIEW = "user-view";
    
    @Input(USERVIEW)
    SubscribableChannel getUserView();
}