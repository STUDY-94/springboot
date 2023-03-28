package com.spring.boot.springboot.psa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;

@Configuration
public class TestPsaConfig {

    @Bean
    @Qualifier("testMailSender2")
    public MailSender testMailSender2() {
        return new TestMailSender();
    }
}
