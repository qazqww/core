package com.raptarior.core.discount;

import com.raptarior.core.member.Grade;
import com.raptarior.core.member.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountPolicyTest {

    DiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();
    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void fixDiscountTest() {
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        Member memberBasic = new Member(2L, "memberBasic", Grade.BASIC);

        int discountVIP = fixDiscountPolicy.discount(memberVIP, 10000);
        int discountBasic = fixDiscountPolicy.discount(memberBasic, 10000);

        assertEquals(discountVIP, 1000);
        assertEquals(discountBasic, 0);
    }

    @Test
    void rateDiscountTest() {
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        Member memberBasic = new Member(2L, "memberBasic", Grade.BASIC);

        int discountVIP = rateDiscountPolicy.discount(memberVIP, 10000);
        int discountBasic = rateDiscountPolicy.discount(memberBasic, 10000);

        assertEquals(discountVIP, 1000);
        assertEquals(discountBasic, 0);
    }
}
