package com.spring.boot.springboot.psa;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.MailSender;

@TestConfiguration
public class TestPsaConfig {

    @Bean
    public MailSender testMailSender() {
        return new TestMailSender();
    }
}
