package com.cavetech.springboot.Accountbank.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class SpringbootAccountApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*int valorDado = (int) Math.floor(Math.random()*99999999+1);
			System.out.println(valorDado);*/
		
		
	}

}
