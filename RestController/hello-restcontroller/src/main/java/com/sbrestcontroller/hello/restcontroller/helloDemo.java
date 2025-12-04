package com.sbrestcontroller.hello.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class helloDemo {

    @GetMapping("/hello")
    public String getHello()
    {
        return "hello world this is my first postman progarm";
    }
}
