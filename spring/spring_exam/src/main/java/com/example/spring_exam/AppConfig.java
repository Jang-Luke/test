package com.example.spring_exam;

import com.example.spring_exam.member.MemberRepository;
import com.example.spring_exam.member.MemberService;
import com.example.spring_exam.member.MemberServiceImpl;
import com.example.spring_exam.member.MemoryMemberRepository;
import com.example.spring_exam.order.DiscountPolicy;
import com.example.spring_exam.order.OrderService;
import com.example.spring_exam.order.OrderServiceImpl;
import com.example.spring_exam.order.RateDiscountPolicy;
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
        return new RateDiscountPolicy();
    }
}
