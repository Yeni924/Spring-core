package com.example.core.singleton;

public class SingletonService {

    //static 영역에 객체 instance를 하나 생성해서 올린다.
    private static final SingletonService instance = new SingletonService();

    // getInstance()메서드를 통해서만 조회할 수 있다.
    public static SingletonService getInstance(){
        return instance;
    }


    //딱 1개의 객체 인스턴스만 존재야하 하므로, 생성자를 private로 만들어 외부에서 생성되는것을 막는다.
    private SingletonService(){
        
    }
    
    public  void logit(){
        System.out.println("싱글톤 객체 로직 호출");
    }
    
}
