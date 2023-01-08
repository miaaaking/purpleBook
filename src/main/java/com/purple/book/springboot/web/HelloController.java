package com.purple.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//JSON을 반환하는 컨트롤러
// @ResponseBody 메소드마다 선언했던 것을 한번에 처리
@RestController
public class HelloController {

    // HTTP Method인 Get의 요청을 받을 수 있는 API 생성
    // @RequestMapping(method=RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
