package com.spring.boot.springboot.psa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class PsaConfig {

    @Bean
    public MailSender mailSender() {
        return new ProdMailSender();
    }
}
