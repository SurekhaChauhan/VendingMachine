package com.java.VendingMachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.java.VendingMachine.service"})
public class VendingMachine {

	public static void main(String[] args) {
		SpringApplication.run(VendingMachine.class, args);

	}

}
