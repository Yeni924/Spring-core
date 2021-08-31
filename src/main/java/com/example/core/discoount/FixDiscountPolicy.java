package com.example.core.discoount;

import com.example.core.member.Grade;
import com.example.core.member.Member;

public class FixDiscountPolicy  implements DisCountPolicy{

    private  int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}