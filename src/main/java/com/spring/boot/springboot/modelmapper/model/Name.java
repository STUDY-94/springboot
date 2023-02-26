package com.spring.boot.springboot.modelmapper.model;

import lombok.Data;

@Data
public class Name {
    String firstName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
