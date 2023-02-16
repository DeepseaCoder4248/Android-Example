package com.example.modulesample;

// 추상메소드를 하나라도 가지는 클래스는 => 추상클래스
// abstract 붙임
public abstract class Monkey {

    public void angry() {
        System.out.println("우끼 화났다");
    }

    // 메소드의 내용이없는 메소드 => 추상메소드
    // 반드시 오버라이딩이 되어야하는 존재
    // 안하면 객체 생성이 안됨 -> 불완전한 추상 상태이므로
    public abstract void eat();
}
