package com.rakeshv.cloudstreamrabbitmqproducer.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * CustomMessageBinding
 */
public interface CustomMessageBinding {

    @Output("custom-message")
    MessageChannel customMessage();
}