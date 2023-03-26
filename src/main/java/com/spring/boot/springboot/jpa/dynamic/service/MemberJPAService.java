package com.spring.boot.springboot.jpa.dynamic.service;

import com.spring.boot.springboot.jpa.dynamic.model.Member;
import com.spring.boot.springboot.jpa.dynamic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;

@Service
public class MemberJPAService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberJPAService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }
}
