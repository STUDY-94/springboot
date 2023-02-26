package com.spring.boot.springboot.modelmapper.model;

import lombok.Data;

@Data
public class Customer {
    Name name;

    public Customer(Name name) {
        this.name = name;
    }

    public Customer(String firstName, String lastName) {
        this.name = new Name(firstName, lastName);
    }
}
