package order;

import com.example.core.member.Member;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemoryMemberRepository;
import discount.DisCountPolicy;
import discount.FixDiscountPolicy;
import discount.RateDiscountPolicy;

public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // private final DisCountPolicy disCountPolicy = new FixDiscountPolicy();
    //새로운 정책한 코드를 실행하려면 RateDiscountPolicy로 수정해야한다.
    // private final DisCountPolicy disCountPolicy = new RateDiscountPolicy();

    private  DisCountPolicy disCountPolicy; //인터페이스만 의존하도록 수정해야한다.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId); //회원 정보 조회
        int discountPrice = disCountPolicy.discount(member,itemPrice); // 할인 정책 받음

        return new Order(memberId,itemName,itemPrice,discountPrice); //새로 생성된 주문 반환받음
    }
}
