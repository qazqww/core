package com.raptarior.core.order;

import com.raptarior.core.discount.DiscountPolicy;
import com.raptarior.core.discount.FixDiscountPolicy;
import com.raptarior.core.discount.RateDiscountPolicy;
import com.raptarior.core.member.Member;
import com.raptarior.core.member.MemberRepository;
import com.raptarior.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); => OCP / DIP 위반
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
