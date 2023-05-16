package com.example.spring_exam.order;

import com.example.spring_exam.member.Grade;
import com.example.spring_exam.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountFixAmount / 100;
        }
        return 0;
    }
}
