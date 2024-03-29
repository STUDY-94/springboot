package com.spring.boot.springboot.psa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.mail.MailSender;

@TestConfiguration
//@Configuration
public class TestPsaConfig {

    @Bean
    @Qualifier("realTestMailSender")
    public MailSender realTestMailSender() {
        return new TestMailSender();
    }
}
