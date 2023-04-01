package com.spring.boot.springboot.logging;

import com.spring.boot.springboot.jpa.dynamic.repository.MemberRepository;
import com.spring.boot.springboot.jpa.dynamic.service.MemberJPAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoggingController {

//    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/logging")
    public String logging() {

        String str = "spring boot logging test";

        log.trace("trace log = {}", str);
        log.debug("debug log = {}", str);
        log.info("info log = {}", str);
        log.warn("warn log = {}", str);
        log.error("error log = {}", str);

        memberRepository.findAll();

        return "success";
    }

}
