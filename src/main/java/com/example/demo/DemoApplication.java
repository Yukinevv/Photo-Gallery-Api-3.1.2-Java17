package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(UserRepository repository) {
//		return args -> {
//			User user = new User("jank1", "qwerty", "jank1@gmail.com");
//
//			repository.insert(user);
//		};
//	}
}
