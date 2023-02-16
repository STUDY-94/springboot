package com.spring.boot.springboot.handler;

import com.spring.boot.springboot.aop.ExceptionResponse;
import com.spring.boot.springboot.aop.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

//    //Excpetion을 통해 예외를 받고 WebRequest를 통해 어디서 에러가 발생했는지 받는다
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> allException(Exception e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    //UserNotFoundException.class 예외가 발생 했을 때 작동
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> userFoundException(Exception e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
