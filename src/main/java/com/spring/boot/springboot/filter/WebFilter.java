package com.spring.boot.springboot.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
//@javax.servlet.annotation.WebFilter(urlPatterns = {"/filter/*", "/filter2/*"})
public class WebFilter implements Filter {

    //필터 인스턴스 초기화
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("---------- 필터 인스턴스 초기화 ----------");
    }

    //전/후 처리
    //Request,Response가 필터를 거칠 때 수행되는 메소드
    //chain.doFilter()를 기점으로 request, response로 나누어진다
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();

        System.out.println("---------- Request(" + requestURI + ") 필터 ----------");
        chain.doFilter(request, response);
        System.out.println("---------- Response(" + requestURI + ") 필터 ----------");
    }

    //필드 인스턴스 종료
    @Override
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("---------- 필터 인스턴스 종료 ----------");
    }
}
/*
init()
웹 컨테이너(톰캣)이 시작될 때 필터 최초 한 번 인스턴스 생성

doFilter()
클라이언트의 요청 시 전/후 처리
FilterChain을 통해 전달

public void destroy()
필터 인스턴스가 제거될 때 실행되는 메서드, 종료하는 기능
 */