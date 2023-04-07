package com.spring.boot.springboot.member;

import com.spring.boot.springboot.exception.model.BusinessException;
import com.spring.boot.springboot.exception.model.ErrorCode;
import com.spring.boot.springboot.jpa.dynamic.controller.MemberJPAController;
import com.spring.boot.springboot.jpa.dynamic.model.Member;
import com.spring.boot.springboot.jpa.dynamic.service.MemberJPAService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberJPAController.class)
public class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MemberJPAService memberJPAService;

    @Test
    @DisplayName("id=1,name=네가 참 좋아,age=2 인 멤버 조회 성공")
    void _1() throws Exception {
        Member member = new Member(1, "네가 참 좋아", 2);

        given(memberJPAService.findOne(1)).willReturn(member);

        final ResultActions actions = mockMvc.perform(get("/jpa/member?id=1")
                        .contentType(MediaType.APPLICATION_JSON));

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("네가 참 좋아"))
                .andExpect(jsonPath("age").value(2));
//                .andDo(print());
    }

    @Test
    @DisplayName("id=1인 멤버가 존재하지 않으면 예외 발생")
    void _2() throws Exception {

        //given
        given(memberJPAService.findOne(1)).willThrow(new BusinessException(ErrorCode.MEMBER_NOT_FOUND));


        //when
        final ResultActions actions = mockMvc.perform(get("/jpa/member?id=1")
                .contentType(MediaType.APPLICATION_JSON));


        //then
        actions
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("status").value(ErrorCode.MEMBER_NOT_FOUND.getStatus()))
                .andExpect(jsonPath("message").value(ErrorCode.MEMBER_NOT_FOUND.getMessage()))
                .andExpect(jsonPath("code").value(ErrorCode.MEMBER_NOT_FOUND.getCode()));
//                .andDo(print());
    }

    @Test
    @DisplayName("멤버 목록 화면 요청")
    void _3() throws Exception {
        //given

        //when
        final ResultActions actions = mockMvc.perform(get("/page/members")
                .contentType(MediaType.TEXT_HTML));

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(view().name("member/memberList"))
                .andExpect(model().attributeExists("attr1"))
                .andExpect(model().attribute("attr1", "attr1"));
    }
}
