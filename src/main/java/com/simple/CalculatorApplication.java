package com.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {

	private static final Logger LOG = LoggerFactory.getLogger(CalculatorApplication.class);

	public static void main(String[] args) {
		LOG.info("CalculatorApplication started");
		SpringApplication.run(CalculatorApplication.class, args);
	}

}
