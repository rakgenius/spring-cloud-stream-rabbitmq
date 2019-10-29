package com.rakeshv.cloudstreamrabbitmqproducer.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * HelloMessagePublisher
 */
@EnableBinding(HelloBinding.class)
public class HelloMessagePublisher {    
}