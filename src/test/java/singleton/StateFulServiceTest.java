package singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton(){

       ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        //Thread A : A사용자가 10000원을 주문
        int orderA =  stateFulService1.order("userA",10000);

        //Thread B: B사용자가 10000원을 주문
       int orderB =  stateFulService2.order("userB",20000);

        //Thread A : 사용자A 주문 금액 조회
        //  int price = stateFulService1.getPrice();
        System.out.println("price = " + orderA);


       // assertThat(stateFulService1.getPrice()).isEqualTo(20000);
    }


    static class TestConfig{

        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }
}