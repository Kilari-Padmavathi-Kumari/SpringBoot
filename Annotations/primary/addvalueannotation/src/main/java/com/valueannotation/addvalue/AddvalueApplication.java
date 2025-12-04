package com.valueannotation.addvalue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddvalueApplication {

	public static void main(String[] args) {

        System.out.println("value injection");SpringApplication.run(AddvalueApplication.class, args);
	}

}
