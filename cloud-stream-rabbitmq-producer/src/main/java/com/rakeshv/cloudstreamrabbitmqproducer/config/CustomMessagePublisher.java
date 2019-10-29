package com.rakeshv.cloudstreamrabbitmqproducer.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * CustomMessagePublisher
 */
@EnableBinding(CustomMessageBinding.class)
public class CustomMessagePublisher {    
}