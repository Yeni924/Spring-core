package com.example.core;

import com.example.core.member.MemberRepository;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.member.MemoryMemberRepository;
import discount.DisCountPolicy;
import discount.FixDiscountPolicy;
import discount.RateDiscountPolicy;
import order.OrderService;
import order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){ //멤버 서비스
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() { // 나중에 DB로 바꿀 경우 여기 코드만 바뀌면된다.
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){ //주문서비스
        //OrderServiceImpl안에 MemberMeberRespository와 FixDiscountPolicy가 넘어감
        return new OrderServiceImpl(memberRepository(),disCountPolicy());
    }

    public DisCountPolicy disCountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
