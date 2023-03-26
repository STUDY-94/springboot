package com.spring.boot.springboot.spring_annotaion._import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config2 {

    @Bean
    public Bean2 bean2() {
        return new Bean2();
    }
}
