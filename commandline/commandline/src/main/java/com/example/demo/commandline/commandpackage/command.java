package com.example.demo.commandline.commandpackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class command {
    @GetMapping("/")
    public String print()
    {
        return "hi padma!,,,,,,";
    }
}
