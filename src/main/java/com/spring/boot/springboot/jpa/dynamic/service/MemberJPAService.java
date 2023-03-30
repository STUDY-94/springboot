package com.spring.boot.springboot.jpa.dynamic.service;

import com.spring.boot.springboot.exception.model.BusinessException;
import com.spring.boot.springboot.exception.model.ErrorCode;
import com.spring.boot.springboot.jpa.dynamic.model.Member;
import com.spring.boot.springboot.jpa.dynamic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Member findOne(int id) {
        return memberRepository
                .findById(id)
                .orElseThrow(() -> {
                    throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
                });
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
