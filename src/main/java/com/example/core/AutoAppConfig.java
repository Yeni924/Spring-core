package com.example.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

//@Component class를 찾아서 다 빈으로 등록해줌
@ComponentScan(
        // Configuration 클래스는 제외 하고 스캔
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {

}
