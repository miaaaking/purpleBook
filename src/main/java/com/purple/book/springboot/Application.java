package com.purple.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
//스프링부트의 자동설정, 스프링Bean 읽기,생성 모두 자동설정되므로 메인클래스로 임명하며 프로젝트 최상단에 위치
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS 실행 (스프링부트로 만들어진 jar 파일로 실행)
        SpringApplication.run(Application.class, args);
    }
}
