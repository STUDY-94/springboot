package com.spring.boot.springboot.jpa.dynamic.service;

import com.spring.boot.springboot.jpa.dynamic.model.Member;
import com.spring.boot.springboot.jpa.dynamic.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberJPAService {

    private final MemberRepository memberRepository;

    public MemberJPAService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void insert(Member member) {
        memberRepository.save(member);
    }

    public void update(Member member) {
        memberRepository.save(member);
    }
}
