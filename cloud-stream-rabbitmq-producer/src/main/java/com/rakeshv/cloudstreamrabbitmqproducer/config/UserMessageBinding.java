package com.rakeshv.cloudstreamrabbitmqproducer.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * UserMessageBinding
 */
public interface UserMessageBinding {
    @Output("user")
    MessageChannel publishUserView();
}