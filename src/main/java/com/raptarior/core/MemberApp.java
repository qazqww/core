package com.raptarior.core;

import com.raptarior.core.member.Grade;
import com.raptarior.core.member.Member;
import com.raptarior.core.member.MemberService;
import com.raptarior.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
        System.out.println(member == findMember);
    }
}
