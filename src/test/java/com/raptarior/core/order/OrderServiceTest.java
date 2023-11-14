package com.raptarior.core.order;

import com.raptarior.core.member.Grade;
import com.raptarior.core.member.Member;
import com.raptarior.core.member.MemberService;
import com.raptarior.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }
}
