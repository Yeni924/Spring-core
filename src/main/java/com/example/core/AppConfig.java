package com.example.core;

import com.example.core.member.MemberRepository;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.member.MemoryMemberRepository;
import com.example.core.discoount.DisCountPolicy;
import com.example.core.discoount.RateDiscountPolicy;
import com.example.core.order.OrderService;
import com.example.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

//    @Bean
//    public OrderService orderService(){
//        System.out.println("call AppConfig.orderService");
//
//        return new OrderServiceImpl(memberRepository(),disCountPolicy());
//    }

    @Bean
    public DisCountPolicy disCountPolicy(){
        return new RateDiscountPolicy();
    }
}
