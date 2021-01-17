package com.ekar.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ekar.counter"}) 
public class EkarCounterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkarCounterServiceApplication.class, args);
	}

}
