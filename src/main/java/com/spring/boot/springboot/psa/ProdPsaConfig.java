package com.spring.boot.springboot.psa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;

@Configuration
public class ProdPsaConfig {

    @Bean
    @Qualifier("prodMailSender2")
    public MailSender prodMailSender2() {
        return new ProdMailSender();
    }
}
