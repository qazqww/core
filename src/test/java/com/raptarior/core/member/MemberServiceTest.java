package com.raptarior.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        Member member2 = new Member(2L, "memberB", Grade.BASIC);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertEquals(member, findMember);
//        Assertions.assertEquals(member2, findMember);
    }
}