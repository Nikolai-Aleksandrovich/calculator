package com.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class ScoreCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreCalculatorApplication.class, args);
	}

}
