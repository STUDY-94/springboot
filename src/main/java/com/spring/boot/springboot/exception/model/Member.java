package com.spring.boot.springboot.exception.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    @NotEmpty
    private String id;
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
