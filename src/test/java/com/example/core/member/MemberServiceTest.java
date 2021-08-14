package com.example.core.member;


import com.example.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforEach(){ //테스트 실행전에 실행됌
        AppConfig appConfig = new AppConfig(); //appConfig 객체 생성
        memberService = appConfig.memberService(); // mmemberService를 주입받는다.

    }

    @Test
    void join(){
        //given , 주어지면
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when, 언제
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 검증
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
