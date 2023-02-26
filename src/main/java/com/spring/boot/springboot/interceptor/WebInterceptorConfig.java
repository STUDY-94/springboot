package com.spring.boot.springboot.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new Interceptor());

        registry.addInterceptor(new Interceptor())
                .excludePathPatterns("/noInterceptor");

        /*
        * excludePathPatterns() : ()안에 지정된 URI나 경로(Path)는 인터셉터 호출에서 제외
        * addPathPatterns()     : ()안에 지정된 URI나 경로(Path)를 인터셉터 호출에 추가
        */
    }
}
