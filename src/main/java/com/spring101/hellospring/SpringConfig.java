package com.spring101.hellospring;

import com.spring101.hellospring.repository.MemberRepository;
import com.spring101.hellospring.repository.MemoryMemberRepository;
import com.spring101.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
