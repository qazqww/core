package com.raptarior.core;

import com.raptarior.core.discount.DiscountPolicy;
import com.raptarior.core.discount.FixDiscountPolicy;
import com.raptarior.core.member.MemberRepository;
import com.raptarior.core.member.MemberService;
import com.raptarior.core.member.MemberServiceImpl;
import com.raptarior.core.member.MemoryMemberRepository;
import com.raptarior.core.order.OrderService;
import com.raptarior.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
