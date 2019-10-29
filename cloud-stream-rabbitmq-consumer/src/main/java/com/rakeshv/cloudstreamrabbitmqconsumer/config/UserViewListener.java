package com.rakeshv.cloudstreamrabbitmqconsumer.config;

import com.rakeshv.userviewdto.model.UserView;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

/**
 * UserViewListener
 */
@EnableBinding(UserViewBinding.class)
@Slf4j
public class UserViewListener {
    @StreamListener(target = UserViewBinding.USERVIEW)
    public void getUserView(UserView userView) {
        log.info("Received message : {}", userView);
    }
    
}