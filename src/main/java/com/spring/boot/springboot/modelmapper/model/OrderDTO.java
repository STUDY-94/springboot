package com.spring.boot.springboot.modelmapper.model;

import lombok.Data;

@Data
public class OrderDTO {
    String customerFirstName;
    String customerLastName;
    String billingStreet;
    String billingCity;

}
