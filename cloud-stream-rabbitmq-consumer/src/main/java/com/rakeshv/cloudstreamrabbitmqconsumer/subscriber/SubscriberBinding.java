package com.rakeshv.cloudstreamrabbitmqconsumer.subscriber;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * SubscriberBinding
 */
public interface SubscriberBinding {

    String QUEUE = "custom-message";

    @Input(QUEUE)
    SubscribableChannel customMessage();
}