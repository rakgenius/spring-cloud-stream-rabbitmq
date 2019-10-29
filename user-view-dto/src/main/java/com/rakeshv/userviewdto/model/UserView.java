package com.rakeshv.userviewdto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserView
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserView {
    private String firstName;
    private String lastName;
    private String organization;
    private String location;
    private String nationality;
    private int age;
}