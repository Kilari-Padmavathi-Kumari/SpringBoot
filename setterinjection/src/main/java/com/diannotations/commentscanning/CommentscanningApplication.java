package com.diannotations.commentscanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.diannotations.commentscanning","com.springboot.util"})
public class CommentscanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentscanningApplication.class, args);
	}

}
