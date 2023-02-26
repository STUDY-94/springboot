package com.spring.boot.springboot.modelmapper.model;

import lombok.Data;

@Data
public class Address {
    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}
