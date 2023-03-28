package com.spring.boot.springboot.psa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
@Qualifier("testMailSender")
public class TestMailSender implements MailSender {
    @Override
    public void send(SimpleMailMessage simpleMessage) throws MailException {
        System.out.println("테스트 코드");
    }

    @Override
    public void send(SimpleMailMessage... simpleMessages) throws MailException {
        System.out.println("테스트 코드");
    }
}
