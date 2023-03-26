package com.spring.boot.springboot.spring_annotaion._import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config1 {

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }
}
