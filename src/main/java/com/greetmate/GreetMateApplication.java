package com.greetmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GreetMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetMateApplication.class, args);
	}

}
