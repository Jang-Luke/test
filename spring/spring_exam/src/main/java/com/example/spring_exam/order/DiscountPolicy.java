package com.example.spring_exam.order;

import com.example.spring_exam.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
