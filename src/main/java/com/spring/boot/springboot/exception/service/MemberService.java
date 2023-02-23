package com.spring.boot.springboot.exception.service;

import com.spring.boot.springboot.exception.model.ErrorCode;
import com.spring.boot.springboot.exception.model.Member;
import com.spring.boot.springboot.exception.model.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    private final Map<String, Member> members = new HashMap<>();

    public List<Member> selectAllMember() {
        if(members.isEmpty()) {
            throw new UserNotFoundException(ErrorCode.MEMBER_NOT_FOUND);
        }
        return new ArrayList<>(members.values());
    }

    public boolean isExistId(String id) {
        return members.containsKey(id);
    }

    public Member join(Member member) {
        members.put(member.getId(), member);
        return members.get(member.getId());
    }

    public Member updateNickname(Member member) {
        if (!isExistId(member.getId())) {
            throw new UserNotFoundException(ErrorCode.MEMBER_ID_NOT_FOUND);
        }
        Member m = members.get(member.getId());
        m.setNickname(member.getNickname());
        return m;
    }
}
