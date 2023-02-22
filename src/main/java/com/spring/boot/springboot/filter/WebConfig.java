package com.spring.boot.springboot.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String[] INCLUDE_PATHS = {
            "/filter/*",
            "/filter2/*"
    };

    @Bean
    public FilterRegistrationBean filterBean() {
        FilterRegistrationBean registerationBean = new FilterRegistrationBean(new WebFilter());
        registerationBean.setOrder(Integer.MIN_VALUE); //필터 여러개 적용시 순번
//        registerationBean.addUrlPatterns("/*"); //전체 URL 포함
//        registerationBean.addUrlPatterns(("/filter/*")); //특정 URL 포함
//        registerationBean.setUrlPatterns(Arrays.asList("/filter/*", "/filter2/*")); //여러 특정 URL 포함
        registerationBean.setUrlPatterns(Arrays.asList(INCLUDE_PATHS)); //여러 특정 URL 포함

        return registerationBean;
    }
}
