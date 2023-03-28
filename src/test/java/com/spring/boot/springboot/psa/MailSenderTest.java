package com.spring.boot.springboot.psa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.mail.MailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @ExtendWith
 * 확장을 선언적으로 등록하는데 사용됩니다. Extendtion 뒤에 인자로 확장할 Extension을 추가하여 사용한다.
 * SpringExtension을 이용하게되면 Spring TestContext Framework와 Junit5와 통합하여 사용하게 되고
 * MockitoExtension을 이용하게되면 Mokito와 관련된 MockContext기반에서 조금은 가볍게 진행이 가능하다.
 * SpringExtension을 이용할 경우 등록된 bean을 가져오려면 @Import을 사용하여 설정 클래스를 명시적으로 등록해야 한다.
 *
 * @SpringBootTest 사용시 @TestConfiguration을 사용한 설정 클래스는 읽지 못한다.
 * @TestConfiguration 사용시 @Import을 사용하여 설정 클래스를 명시적으로 등록해야 한다.
 */
//@SpringBootTest
@ExtendWith({SpringExtension.class})
@Import({TestPsaConfig.class})
public class MailSenderTest {

    private final MailSender mailSender;

    public MailSenderTest(@Autowired
                          @Qualifier("realTestMailSender")
//                          @Qualifier("testMailSender")
//                          @Qualifier("prodMailSender")
                          MailSender testMailSender) {
        this.mailSender = testMailSender;
    }

    @Test
    public void sendMail() {
        mailSender.send();
    }
}

