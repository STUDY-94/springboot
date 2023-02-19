package com.spring.boot.springboot.exception.controller;

import com.spring.boot.springboot.exception.model.ExceptionResponse;
import com.spring.boot.springboot.exception.model.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.net.BindException;
import java.util.Date;

@RestController
public class AopController {

    @GetMapping(value = "/user", produces = "text/plain; charset=utf-8")
    public String user(String id) {
        throw new UserNotFoundException(String.format("존재하지 않는 회원 [ ID : %s ]", id));
//        return id;
    }

//    @GetMapping(value="/user2")
//    public String user2() {
//        UserNotFoundException unfe = new UserNotFoundException("새로운 객체 생성");
//        unfe.UserNotFoundException2();
//        return null;
//    }

    @GetMapping("/testError1")
    public String exceptionHandlerTest(String str) throws Exception {
        if(str.length() > 2) {
            return str;
        }
        throw new NullPointerException();
    }

    //GobalControllerAdive에서 정의한 ExceptionHandler에 매핑되어 처리
    @GetMapping("/testError2")
    public String bindExceptionTest(String str) throws Exception {
        if(str.length() > 2) {
            return str;
        }
        throw new BindException();
    }


    //특정 Controller에서 예외가 발생한 경우 ExceptionHandler를 검색하여 처리
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResponse> nullException(WebRequest request) {
        ResponseEntity<ExceptionResponse> er = ResponseEntity.badRequest().body(
                new ExceptionResponse(new Date(), "NullPointerException", request.getDescription(false))
        );
        System.out.println("error Code : " + er);
        return er;
    }
}
