package com.hufu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.hufu.*")
@SpringBootApplication
public class HufuApplication {

	public static void main(String[] args) {
		SpringApplication.run(HufuApplication.class, args);
	}
}
