package com.example.core.order;

import com.example.core.member.Member;
import com.example.core.member.MemberRepository;
import com.example.core.discoount.DisCountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService{

    private  MemberRepository memberRepository;
    private  DisCountPolicy disCountPolicy;

    @Autowired(required = false)
    public void setDisCountPolicy(DisCountPolicy disCountPolicy) {
        this.disCountPolicy = disCountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }





    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

}
