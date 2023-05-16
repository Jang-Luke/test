package com.example.spring_exam.order;

import com.example.spring_exam.member.Member;
import com.example.spring_exam.member.MemberRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String item, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, item, itemPrice, discountPrice);
    }
}
