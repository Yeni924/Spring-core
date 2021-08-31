package order;

import com.example.core.member.Member;
import com.example.core.member.MemberRepository;
import discount.DisCountPolicy;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DisCountPolicy disCountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository, DisCountPolicy disCountPolicy) {
        this.memberRepository = memberRepository;
        this.disCountPolicy = disCountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

}
