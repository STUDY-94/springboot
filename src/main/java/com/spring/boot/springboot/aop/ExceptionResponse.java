package com.spring.boot.springboot.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {    //예외가 발생하면 해당 객체에 값을 넣어 사용자에게 전달할 클래스

    private Date date;      //예외 발생 날짜
    private String message; //예외 메세지
    private String content; //예외가 어느 요청에서 났는지 확인

}
