package com.spring.boot.springboot.exception.controller;

import com.spring.boot.springboot.exception.model.Member;
import com.spring.boot.springboot.exception.service.MemberService;
import com.spring.boot.springboot.exception.validator.LengthCheck;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.xml.ws.Response;

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

    @GetMapping("/member")
    public ResponseEntity<Member> getMember(@RequestBody @Valid Member member) {
        return new ResponseEntity<>(new Member("id", "123"), HttpStatus.OK);
    }

    @PutMapping("/member/nickname")
    public ResponseEntity<Member> nickname(@RequestBody @Valid Member member) {
        Member result = memberService.updateNickname(member);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/member")
    public ResponseEntity<Member> joinMember(@RequestBody @Valid Member member) {
        Member result = memberService.join(member);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
