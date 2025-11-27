package com.example.usingSettergetter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UsingSettergetterApplication {

	public static void main(String[] args) {

        System.out.println("new");
		ConfigurableApplicationContext context=SpringApplication.run(UsingSettergetterApplication.class, args);
        NewClass cl=context.getBean(NewClass.class);
        cl.show();
	}

}
