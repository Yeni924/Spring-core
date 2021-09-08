# Spring-core
스프링 핵심 원리 공부 


https://kwonyeeun.tistory.com/m/category/Study%20Note/Spring%20%20%EC%99%84%EC%A0%84%20%EC%A0%95%EB%B3%B5%20%EA%B0%95%EC%9D%98%20%EC%A0%95%EB%A6%AC



# 1. Spring과 객체 지향 설계
 - https://kwonyeeun.tistory.com/65?category=1040556
 - 객체 지향의 핵심은 다형성
 - 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없고, 코드도 함께 변경된다, OCP, DIP를 지킬 수 없음.

---


# 2. 스프링과 핵심 원리 - 순수 자바 예제
 - https://kwonyeeun.tistory.com/70?category=1040556
 - 순수 자바를 사용해서 회원과 주문, 할인정책을 구현, OCP와, DIP 원칙이 잘지켜지진 못함. 
 - 의존관계가 인터페이스 뿐 아니라 구현까지 모두 의존하는 문제

---



# 3. 스프링 핵심 원리 이해2 - 객체 지향 원리 적용
 - https://kwonyeeun.tistory.com/71?category=1040556
 
 #### SRP 단일 책임 원칙 
  - 한 클래스는 하나의 책임만 가져야 한다.
  - 구현 객체를 생성하고 연결하는 책임은 AppConfig가 담당
  - 클라이언트 객체는 실행하는 책임만 담당


#### DIP 의존관계 역전 원칙
  - 추성화에 의존하고, 구체화에 의존하면 안 된다
  - AppCofing가 객체 인스턴스를 클라이언트 코드 대신 생성 후, 클라이언트 코드에 의존관계를 주입해서 문제 해결


#### OCP 
  - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀있어야 한다.
  - 애플리케이션을 사용 영역과 구성 영역으로 나눔
  - AppConfig가 의존관계를 변경하면 클라이언트 코드에 주입하여 클라이언트 코드는 변경하지 않아도 된다.


---



# 4. 스프링 컨테이너와 스프링 빈
 - https://kwonyeeun.tistory.com/72?category=1040556
 
#### BeanFactory
  - 스프링 컨테이너의 최상위 인터페이스로, 스프링 빈을 관리하고 조회하는 역할 ex. getBean() 

#### ApplicationContext
  - BeanFactory 기능을 모두 상속받아 제공
  - BeanFactory 추가로, 애플리케이션을 개발할 때 빈을 관리, 조회 및 수 많은 부가 기능을 제공함


---


# 5. 싱글톤 컨테이너
  - https://kwonyeeun.tistory.com/82?category=1040556

   #### 싱글톤 패턴 
   - 객체가 1개가 생성되고, 공유
   #### 싱글톤 패턴의 문제점
   #### 싱글톤 방식의 주의점 
   - 싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안됌,무상태(stateless)로 설계해야 한다.
   #### @Configuration과 싱글톤 
   - Configuration을 사용 CGLIB로 싱글톤을 보장한다.
   
   
---
# 6. 컴포넌트 스캔
   - https://kwonyeeun.tistory.com/83
   
   분기 : #2 from ktech960924/ComponentScanRe
   
  #### 컴포넌트 스캔과 의존관계 자동 주입
  #### 탐색 위치와 기본 스캔 대상
  #### 필터
  #### 중복 등록과 충돌
  
  
  
  ---
  # 7. 의존관계 자동 주입
   - https://kwonyeeun.tistory.com/87
   
  #### 다양한 의존 관계 주입방법
   - 생성자 주입을 선택 .  의존관계 주입은 한번 일어나면 애플리케이션 종료 시점까지 의존 관계를 변경할 일이 없다. 생성자 주입으로 불변하게 설계하자

  #### 옵션 처리
   - Autowired(required=false) : 메서드 자체가 호출 안된다.
   - @Nullable : 자동 주입할 대상이 없으면 null 출력
   - Optional<> : 자동 주입할 대상이 없으면 Optional.empty 출력


  #### 조회 빈이 2개 이상 일떄?
   - @Primary : 우선순위를 정하는 방법
   - @Qualifier :  추가 구분자를 붙여주는 방법
   - 메인 데이터베이스 @Primary로, 서브 데잍터베이스는 @Qulifier를 지정해서 명시적으로 획득하는 방식으로 하면 코드가 깔끔하게 유지 된다.


 ---
  # 8. 빈 생명주기 콜백
  #### 빈 생명주기 콜백 시작
   
   - 빈 생명주기 
   
   ```
   스프링 컨테이너 생성-> 스프링빈 생성-> 의존 관계 주입->초기화 콜백-> 사용-> 소멸 전 콜백 -> 스프링 종료
   ```
   

  #### 인터페이스 InitializingBean, DisposableBean
  - InitializingBean, DisposableBean을 상속 받으면 빈의 초기화 시점과, 소멸 시점을 알 수 있다.
  - InitializingBean - afterPropertiesSet : 빈 생성 후 의존 주입 후 실행된다.
  - DisposableBean - destory() : 소멸

  #### 빈 등록 초기화, 소멸 메서드
  - 설정 정보를 사용 해 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있다.
 
  #### @PostContruct, @PreDestory
  - 최신 스프링에서 권장하는 방법
  - 단점은 외부 라이브러리에는 적용 못한다.
  - 외부 라이브러리는 @Bean의 기능을 사용하면 된다.
   
