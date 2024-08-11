package com.movoto.movoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.movoto.movoto")
public class MovotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovotoApplication.class, args);
	}

}
