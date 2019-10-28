package com.rakeshv.cloudstreamrabbitmqproducer.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * HelloBinding
 */
public interface HelloBinding {

    @Output("greetingChannel")
    MessageChannel greeting();
}