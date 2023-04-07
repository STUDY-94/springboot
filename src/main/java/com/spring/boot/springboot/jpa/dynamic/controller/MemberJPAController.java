package com.spring.boot.springboot.jpa.dynamic.controller;

import com.spring.boot.springboot.jpa.dynamic.model.Member;
import com.spring.boot.springboot.jpa.dynamic.service.MemberJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberJPAController {

    private final MemberJPAService memberJPAService;

    public MemberJPAController(MemberJPAService memberJPAService) {
        this.memberJPAService = memberJPAService;
    }

    @GetMapping(value = "/jpa/members")
    @ResponseBody
    public ResponseEntity<List<Member>> findAll() {
        return new ResponseEntity<>(memberJPAService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/jpa/member")
    @ResponseBody
    public ResponseEntity<Member> findOne(@RequestParam int id) {
        return new ResponseEntity<>(memberJPAService.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/page/members")
    public ModelAndView renderMembers() {
        ModelAndView mv = new ModelAndView("member/memberList");
        mv.addObject("attr1", "attr1");
        mv.addObject("members", memberJPAService.findAllWithException());
        return mv;
    }

    @GetMapping("/hello/member")
    @ResponseBody
    public String helloMember() {
        return "Hello Member";
    }
}
