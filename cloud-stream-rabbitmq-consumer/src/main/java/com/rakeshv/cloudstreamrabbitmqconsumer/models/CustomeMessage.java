package com.rakeshv.cloudstreamrabbitmqconsumer.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CustomeMessage
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomeMessage {

    private String message;
    private Date date;
}