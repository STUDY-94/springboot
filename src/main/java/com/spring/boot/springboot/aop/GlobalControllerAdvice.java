package com.spring.boot.springboot.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.BindException;
import java.util.Date;

@RestControllerAdvice //@RestController+@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ExceptionResponse> bindExceptionError(BindException e, WebRequest request) {
        ResponseEntity<ExceptionResponse> errorMessage = ResponseEntity.badRequest().body(
                new ExceptionResponse(new Date(), "BindException", request.getDescription(false))
        );
        System.out.println("global error Code : " + errorMessage);
        return  errorMessage;
    }


}
