package com.spring.boot.springboot.exception.model;

import lombok.Data;

@Data
public class Member {

    private String id;
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }
}