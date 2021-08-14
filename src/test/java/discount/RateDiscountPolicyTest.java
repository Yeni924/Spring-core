package discount;

import com.example.core.member.Grade;
import com.example.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다.")
    void vip_o(){ //vip는 잘 적용되야함

        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(1000);

    }

    //실패테스트도 만들어봐야함

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 되면 안된다.")
    void vip_x(){ //vip는 잘 적용되야함

        //given
        Member member = new Member(2L,"memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member,10000);

        //then
        //  Assertions.assertThat(discount).isEqualTo(1000); //실패함
        assertThat(discount).isEqualTo(0);

    }
}