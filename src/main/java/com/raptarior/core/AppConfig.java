package com.raptarior.core;

import com.raptarior.core.discount.DiscountPolicy;
import com.raptarior.core.discount.FixDiscountPolicy;
import com.raptarior.core.member.MemberRepository;
import com.raptarior.core.member.MemberService;
import com.raptarior.core.member.MemberServiceImpl;
import com.raptarior.core.member.MemoryMemberRepository;
import com.raptarior.core.order.OrderService;
import com.raptarior.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
