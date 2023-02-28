package com.spring.boot.springboot.filter.xss.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class XssConfig implements WebMvcConfigurer {

    @Bean
    public MappingJackson2HttpMessageConverter jsonEscapeConverter() {
        // MappingJackson2HttpMessageConverter Default ObjectMapper 설정 및 ObjectMapper Config 설정
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

    /*
     여기서 한 가지 추가로 설명하자면 처음에는 아래와 같은 코드로 ObjectMapper 객체를 생성해 주었으나
     ObjectMapper objectMapper = new ObjectMapper();
     기존의 정상적으로 Mapping 되던 객체가 정상적으로 Mapping이 되지 않아
     MappingJackson2HttpMessageConverter 해당 클래스의 Default ObjectMapper를 찾아보게 되었고
     MappingJackson2HttpMessageConverter 클래스의 생성자를 보면 아래와 같은 코드로
     ObjectMapper를 생성해주는 점을 참고하여 사용하였다.
     Jackson2ObjectMapperBuilder.json().build();
     그 결과 사이드 이펙트 또한 발생하지 않고 정상적으로 XSS 공격을 막을 수 있게 되었다.
    출처] https://inseok9068.github.io/springboot/springboot-xss-response/
    * */
}
