package com.newproject.springboot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootProjectApplication.class, args);
    }
}
// http://localhost:8080/magic-api/members
// used in sorted http://localhost:8080/magic-api/members?lastname,desc