package com.rakeshv.cloudstreamrabbitmqproducer;

import com.rakeshv.cloudstreamrabbitmqproducer.config.CustomMessageBinding;
import com.rakeshv.cloudstreamrabbitmqproducer.config.HelloBinding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(value = {HelloBinding.class, CustomMessageBinding.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
