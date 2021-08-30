package com.example.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

  //  private final MemberRepository memberRepository = new MemoryMemberRepository(); //실제 할당하는 부분이 구체화에 의존함, DIP 위반

    //생성자를 통해 어떤 구현 객체가 들어올지는 알수없다. 오직, AppConfig에서 결정이된다.
    private final MemberRepository memberRepository;

    @Autowired //자동 의존 관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) { //생성자 주입
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //test용도
//    public MemberRepository getMemberRepository(){
//        return memberRepository;
//    }
}
