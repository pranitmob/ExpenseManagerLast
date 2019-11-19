package com.app.ExpenseManagerLast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ExpenseManagerlastApplication {

	public static void main(String[] args) {
		System.out.println("chanegd for github");
		SpringApplication.run(ExpenseManagerlastApplication.class, args);
	}
}
