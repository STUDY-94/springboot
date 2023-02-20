package com.spring.boot.springboot.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

//    public UserNotFoundException(String errorMessage) {
//        super(errorMessage);
//    }

//    public String UserNotFoundException2() {
//        return "UserNotFoundException222";
//    }
}
