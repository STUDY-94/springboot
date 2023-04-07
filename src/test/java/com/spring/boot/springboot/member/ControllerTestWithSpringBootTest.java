package com.spring.boot.springboot.member;

import com.spring.boot.springboot.jpa.dynamic.controller.MemberJPAController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTestWithSpringBootTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberJPAController memberJPAController;

    @Test
    @DisplayName("controller_autowired_테스트")
    public void _1() {
        assertThat(memberJPAController, notNullValue());
    }

    @Test
    @DisplayName("helloWorld_테스트")
    public void _2() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/hello/member", String.class);

//        assertThat(response, is("Hello Member"));
        Assertions.assertEquals(response, "Hello Member");
    }
}
