package com.spring.boot.springboot.psa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.mail.MailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @ExtendWith
 * 확장을 선언적으로 등록하는데 사용됩니다. Extendtion 뒤에 인자로 확장할 Extension을 추가하여 사용합니다.
 * SpringExtension을 이용하게되면 Spring TestContext Framework와 Junit5와 통합하여 사용하게 되고
 * MockitoExtension을 이용하게되면 Mokito와 관련된 MockContext기반에서 조금은 가볍게 진행이가능하다.
 */
@ExtendWith({SpringExtension.class})
//@SpringBootTest
@Import({TestPsaConfig.class})
public class MailSenderTest {

    private final MailSender mailSender;

    public MailSenderTest(@Autowired MailSender testMailSender) {
        this.mailSender = testMailSender;
    }

    @Test
    public void sendMail() {
        mailSender.send();
    }
}
