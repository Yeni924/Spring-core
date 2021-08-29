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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration //설정정보
public class AppConfig {

    //memberService -> MemoryMemberRepository 호출
    //orderService -> MemoryMemberRepository 재호출

    @Bean //스프링 컨테이너에 등록
    public MemberService memberService(){ //멤버 서비스
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() { // 나중에 DB로 바꿀 경우 여기 코드만 바뀌면된다.
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){ //주문서비스
        System.out.println("call AppConfig.orderService");
        //OrderServiceImpl안에 MemberMeberRespository와 FixDiscountPolicy가 넘어감
        return new OrderServiceImpl(memberRepository(),disCountPolicy());
    }

    @Bean
    public DisCountPolicy disCountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
