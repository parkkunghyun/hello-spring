package com.spring101.hellospring.service;

import com.spring101.hellospring.domain.Member;
import com.spring101.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 이러면 new로 생성하는게 아닌 외부에서 넣어주는 거기 때문에 같은 ㄱ주소를 공유!


    /**
     *
     * 회원가입
     */
    public Long join(Member member) {
        // 중복제거!
        validateDuplicateMember(member); //중복회원검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw  new IllegalStateException("이미 존재");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
