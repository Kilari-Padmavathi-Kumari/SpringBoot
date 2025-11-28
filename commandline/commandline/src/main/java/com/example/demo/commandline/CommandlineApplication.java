package com.example.demo.commandline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandlineApplication {


	public static void main(String[] args) {

        System.out.print("hello");SpringApplication.run(CommandlineApplication.class, args);
	}

}
