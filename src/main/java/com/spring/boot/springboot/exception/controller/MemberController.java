package com.spring.boot.springboot.exception.controller;

import com.spring.boot.springboot.exception.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/list")
    public String renderMemberList() {
        return "member/memberList";
    }

    @GetMapping("/ajax/members")
    public ModelAndView getAjaxMembers() {
        ModelAndView mv = new ModelAndView("/member/memberListAjax");
        mv.addObject("listItem", memberService.selectAllMember());
        return mv;
    }
}
