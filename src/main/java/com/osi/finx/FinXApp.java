package com.osi.finx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.osi.finx.model"})
public class FinXApp {

	public static void main(String[] args) {
		SpringApplication.run(FinXApp.class, args);
	}
}
