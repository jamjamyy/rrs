package com.jamjam.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {

    // Request Parameter 방식
    @GetMapping("/test/param")
    public String requestParam(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    ){
        return "Hello, Request Param, I am " + name + ", " + age;
    }

    // Path Variable 방식
    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ){
        return "Hello, Path Variable, I am " + name + ", " + age;
    }

    // Request Body 방식 -> 보통 Get보다 Post나 Put에서 많이 쓰임
    @PostMapping("/test/body")
    public String requestBody(
            @RequestBody TestRequestBody request
    ){
        return "Hello, Request body, I am " + request.name + ", " + request.age;
    }

    public static class TestRequestBody{

        String name;
        Integer age;

        // 스프링 규칙 : RequestBody를 사용할 때는 생성자를 꼭 만들어줘야 함.
        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

    }
}
