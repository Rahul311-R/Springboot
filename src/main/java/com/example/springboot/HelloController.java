package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

record Greeting(String message) {}

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Greeting sayHello() {
        return new Greeting("Hello, Rahul! Welcome to Spring Boot with Java 21");
    }
}
