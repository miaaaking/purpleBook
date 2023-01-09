package com.purple.book.springboot.web;//import org.junit.Test; //junit ver4
//import org.junit.runner.RunWith; //junit ver4

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class) //junit ver4
// JUnit 내장 실행자 + 스프링 실행자 SpringExtension 연결 수행
@ExtendWith(SpringExtension.class)
// Web Spring MVC에 집중할 수 있는 어노테이션으로, @Service, @Repository 등 사용불가 but @Controller 사용가능
// Controller = HelloController.class
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    // Spring Bean 주입
    @Autowired
    // 웹 api test로, spring mvc test 시작점
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        
        // MockMvc를 통해 /hello 주소로 HTTP GET 요청
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // HTTP Header의 Status(200인지 ok인지) 검증
                .andExpect(content().string(hello)); // perform 결과 검증(Controller에서 응답하는 hello가 맞는지 검증)
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
