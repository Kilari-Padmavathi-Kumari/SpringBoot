package com.Springboot.hellosamplesb.ActuatorSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Security {

    @GetMapping("/helloworld")
    public String sayHello() {
        return "hello world";
    }
}
