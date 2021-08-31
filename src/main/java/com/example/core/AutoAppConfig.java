package com.example.core;

import com.example.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

@ComponentScan(
        basePackages = "com.example.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {

// 빈 중복 예제 관련 테스트이나, 부트 실행시 오류 발생하므로 주석 처리

//    @Bean(name = "memoryMemberRepository")
//    MemoryMemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}
