package com.example.SessionOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SessionOneApplication {

	public static void main(String[] args) {

		SpringApplication.run(SessionOneApplication.class, args);
		System.out.println("Hello world");
	}

}
