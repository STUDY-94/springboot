package com.spring.boot.springboot.jpa.dynamic;

import com.spring.boot.springboot.jpa.dynamic.model.Member;
import com.spring.boot.springboot.jpa.dynamic.repository.MemberRepository;
import com.spring.boot.springboot.jpa.dynamic.service.MemberJPAService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;

//import javax.transaction.Transactional;

@SpringBootTest
public class DynamicUpdateTest {

    @Autowired
    MemberJPAService memberJPAService2;

    /**
     * @DynamicUpdate 사용시 udpate 쿼리가 변경된 컬럼만으로 생성된다.
     */
    @Test
    @DisplayName("dynamic update 테스트")
    @Transactional
    public void _1() {
        Member member = new Member();
        member.setId(1);
        member.setAge(30);
        member.setName("안경닦이");

        Member updateMember = memberJPAService2.save(member);

        Assertions.assertEquals(30, updateMember.getAge());
        Assertions.assertEquals("안경닦이", updateMember.getName());
        Assertions.assertNull(updateMember.getDelYn());
        Assertions.assertNull(updateMember.getCrtBy());
        Assertions.assertNull(updateMember.getCrtDt());
    }
}
