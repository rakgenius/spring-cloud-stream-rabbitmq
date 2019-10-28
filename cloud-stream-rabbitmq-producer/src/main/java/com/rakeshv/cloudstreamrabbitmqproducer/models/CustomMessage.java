package com.rakeshv.cloudstreamrabbitmqproducer.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CustomMessage
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomMessage {
    private String message;
    private Date date;
    
}