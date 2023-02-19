package com.spring.boot.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private long startTime;

//    @Before("execution(public String||boolean com.spring..*.*(..))")
//    public void onBeforeHandler(JoinPoint joinPoint) {
//        startTime = System.nanoTime();
//        System.out.println("start : " + startTime);
//    }
//
//    @After("execution(* com.spring..*(..))")
//    public void onAfterHandler(JoinPoint joinPoint) {
//        long endTime = System.nanoTime();
//        System.out.println("elapsed time : " + (endTime - startTime));
//    }
//
//    @Around("execution(* check*()) && within(com.spring..*)")
//    public String around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        String returnValue = null;
//        try {
//            returnValue = (String) proceedingJoinPoint.proceed();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        returnValue = "**" + returnValue + "**";
//        return  returnValue;
//    }
}
