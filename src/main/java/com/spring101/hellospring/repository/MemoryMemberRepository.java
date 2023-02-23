package com.spring101.hellospring.repository;

import com.spring101.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository  implements  MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 공유되는 변수에는 이거 안적기는 함
    private static long sequence = 0L; //1 2 3 등 숫자 적어줌
    // 동시성 문제를 고려해서 다르게 적긴해야한다고 함
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
