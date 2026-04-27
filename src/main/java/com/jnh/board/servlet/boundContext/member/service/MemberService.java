package com.jnh.board.servlet.boundContext.member.service;


import com.jnh.board.servlet.boundContext.base.Container;
import com.jnh.board.servlet.boundContext.member.dto.Member;
import com.jnh.board.servlet.boundContext.member.repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = Container.memberRepository;
    }

    public void join(String username, String password, String name) {
        memberRepository.save(username, password, name);
    }

    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}
