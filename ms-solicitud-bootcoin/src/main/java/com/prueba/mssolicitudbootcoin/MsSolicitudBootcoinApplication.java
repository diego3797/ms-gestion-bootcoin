package com.prueba.mssolicitudbootcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.prueba.mssolicitudbootcoin")
public class MsSolicitudBootcoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSolicitudBootcoinApplication.class, args);
	}

}
