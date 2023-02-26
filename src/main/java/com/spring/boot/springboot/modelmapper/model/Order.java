package com.spring.boot.springboot.modelmapper.model;

import lombok.Data;

@Data
public class Order {
    Customer customer;
    Address billingAddress;

    public Order(String firstName, String lastName, String city, String street) {
        this.customer = new Customer(firstName, lastName);
        this.billingAddress = new Address(street, city);
    }
}
