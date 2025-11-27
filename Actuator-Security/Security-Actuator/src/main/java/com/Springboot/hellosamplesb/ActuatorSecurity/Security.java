package com.Springboot.hellosamplesb.ActuatorSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Security {
    //expose "/" that return "hello world"
    @GetMapping("/")
    public String sayHello()
    {
        return "hello world";
    }
}
