package com.example.core.beanfind;

import com.example.core.AppConfig;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemberService;
import com.example.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class ApplicationContectSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate(){
    //    MemberRepository bean = ac.getBean(MemberRepository.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈이름을 지정하면된다.")
    void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(memberRepository).isInstanceOf((MemberRepository.class));
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findBeanAllByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key+\"vakye =\"+beansOfType = " + key+"vakye ="+beansOfType);
            assertThat(beansOfType.size()).isEqualTo(2);
        }
    }

    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }

    }
}
