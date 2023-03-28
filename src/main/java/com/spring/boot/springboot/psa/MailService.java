package com.spring.boot.springboot.psa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final MailSender mailSender;

    public MailService(@Qualifier("prodMailSender") MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send() {
        mailSender.send();
    }
}
