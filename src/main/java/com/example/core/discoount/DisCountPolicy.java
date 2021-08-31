package com.example.core.discoount;


import com.example.core.member.Member;

public interface DisCountPolicy {

    int discount(Member member, int price);
}

