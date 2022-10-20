package com.jojoldo.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* 스프링부트의 자동설정
    , Bean 읽기 생성 자동 설정 해당 어노테이션의 위치부터 설정을 읽어감 */
public class Application { // 프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 was실행
    }
}
