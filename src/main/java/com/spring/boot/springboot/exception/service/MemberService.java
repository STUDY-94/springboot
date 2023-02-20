package com.spring.boot.springboot.exception.service;

import com.spring.boot.springboot.exception.model.BusinessException;
import com.spring.boot.springboot.exception.model.ErrorCode;
import com.spring.boot.springboot.exception.model.Member;
import com.spring.boot.springboot.exception.model.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    public List<Member> selectAllMember() {
//        if((int)(Math.random() * 10) < 4) {
            throw new UserNotFoundException(ErrorCode.MEMBER_NOT_FOUND);
//        }
//        return List.of(new Member("coding2080", "유태형"), new Member("ssolly-choi", "최소영"));
    }
}
