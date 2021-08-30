package order;

import com.example.core.member.Member;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemoryMemberRepository;
import discount.DisCountPolicy;
import discount.FixDiscountPolicy;
import discount.RateDiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository;
    private final DisCountPolicy disCountPolicy; //인터페이스만 의존하도록 수정해야한다.


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DisCountPolicy disCountPolicy) {
        this.memberRepository = memberRepository;
        this.disCountPolicy = disCountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId); //회원 정보 조회
        int discountPrice = disCountPolicy.discount(member,itemPrice); // 할인 정책 받음

        return new Order(memberId,itemName,itemPrice,discountPrice); //새로 생성된 주문 반환받음
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
