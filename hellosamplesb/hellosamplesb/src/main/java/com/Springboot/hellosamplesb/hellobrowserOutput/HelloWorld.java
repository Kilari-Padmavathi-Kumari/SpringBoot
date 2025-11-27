package com.Springboot.hellosamplesb.hellobrowserOutput;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    //expose "/" that return "hello world"
    @GetMapping("/")
    public String sayHello()
    {
        return "hello world";
    }
}
