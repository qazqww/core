package com.raptarior.core;

import com.raptarior.core.member.Grade;
import com.raptarior.core.member.Member;
import com.raptarior.core.member.MemberService;
import com.raptarior.core.member.MemberServiceImpl;
import com.raptarior.core.order.Order;
import com.raptarior.core.order.OrderService;
import com.raptarior.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
//        System.out.println(order.calculatedPrice());
    }
}
