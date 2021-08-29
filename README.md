# Spring-core
스프링 핵심 원리 공부 


https://kwonyeeun.tistory.com/m/category/Study%20Note/Spring%20%20%EC%99%84%EC%A0%84%20%EC%A0%95%EB%B3%B5%20%EA%B0%95%EC%9D%98%20%EC%A0%95%EB%A6%AC



1. Spring과 객체 지향 설계
 - https://kwonyeeun.tistory.com/65?category=1040556
 - 객체 지향의 핵심은 다형성
 - 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없고, 코드도 함께 변경된다, OCP, DIP를 지킬 수 없음.



2. 스프링과 핵심 원리 - 순수 자바 예제
 - https://kwonyeeun.tistory.com/70?category=1040556
 - 순수 자바를 사용해서 회원과 주문, 할인정책을 구현, OCP와, DIP 원칙이 잘지켜지진 못함. 
 - 의존관계가 인터페이스 뿐 아니라 구현까지 모두 의존하는 문제



3. 스프링 핵심 원리 이해2 - 객체 지향 원리 적용
 - https://kwonyeeun.tistory.com/71?category=1040556
 
 * SRP 단일 책임 원칙 
  - 한 클래스는 하나의 책임만 가져야 한다.
  - 구현 객체를 생성하고 연결하는 책임은 AppConfig가 담당
  - 클라이언트 객체는 실행하는 책임만 담당


 * DIP 의존관계 역전 원칙
  - 추성화에 의존하고, 구체화에 의존하면 안 된다
  - AppCofing가 객체 인스턴스를 클라이언트 코드 대신 생성 후, 클라이언트 코드에 의존관계를 주입해서 문제 해결


 * OCP 
  - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀있어야 한다.
  - 애플리케이션을 사용 영역과 구성 영역으로 나눔
  - AppConfig가 의존관계를 변경하면 클라이언트 코드에 주입하여 클라이언트 코드는 변경하지 않아도 된다.



4. 스프링 컨테이너와 스프링 빈
 - https://kwonyeeun.tistory.com/72?category=1040556
 
   BeanFactory
  - 스프링 컨테이너의 최상위 인터페이스로, 스프링 빈을 관리하고 조회하는 역할 ex. getBean() 

   ApplicationContext
  - BeanFactory 기능을 모두 상속받아 제공
  - BeanFactory 추가로, 애플리케이션을 개발할 때 빈을 관리, 조회 및 수 많은 부가 기능을 제공함



5. 싱글톤 컨테이너
  - https://kwonyeeun.tistory.com/82?category=1040556

   싱글톤 패턴 : 객체가 1개가 생성되고, 공유
   싱글톤 패턴의 문제점
   싱글톤 방식의 주의점 :  싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안됌,무상태(stateless)로 설계해야 한다.
   @Configuration과 싱글톤 : Configuration을 사용 CGLIB로 싱글톤을 보장한다.
   
