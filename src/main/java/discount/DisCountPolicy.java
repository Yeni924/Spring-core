package discount;


import com.example.core.member.Member;

public interface DisCountPolicy {

    int discount(Member member, int price);
}

