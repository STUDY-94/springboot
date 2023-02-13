package com.spring.boot.springboot.controller;

import com.spring.boot.springboot.aop.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @GetMapping(value = "/user", produces = "text/plain; charset=utf-8")
    public String user(String id) {
        throw new UserNotFoundException(String.format("존재하지 않는 회원 [ ID : %s ]", id));
    }
}
