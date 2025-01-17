package com.jamjam.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseApi {

    @GetMapping("/test/response/string")
    public String StringResponse(){
        return "This is String";
    }

    @GetMapping("/test/response/json")
    public TestResponseBody jsonResponse(){
        return new TestResponseBody("jam", 27);
    }

    public static class TestResponseBody{
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public TestResponseBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
