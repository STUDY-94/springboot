package com.spring.boot.springboot.jpa.dynamic.repository;

import com.spring.boot.springboot.jpa.dynamic.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
//public class MemberRepository {
}
