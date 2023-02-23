package com.spring101.hellospring.repository;

import com.spring101.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // null을 그냥 처리가 아닌 optional로 감싸서 처리!
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
