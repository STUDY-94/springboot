package com.spring.boot.springboot.spring_annotaion._import;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import({config1.class, config2.class})
public class ImportConfig {

    @Bean
//    @Primary
    @Qualifier("realIA")
//    public ImportAnnotation importAnnotation(Bean1 bean1, Bean2 bean2) {
//    public ImportAnnotation importAnnotation2(Bean1 bean1, Bean2 bean2) {
    public ImportAnnotation importAnnotation3(Bean1 bean1, Bean2 bean2) {
        return new ImportAnnotation(bean1, bean2);
    }
}
