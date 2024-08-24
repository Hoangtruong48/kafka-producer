package com.appsdeveloperblogs.ws.productmicroservice;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
@Slf4j
public class ProductMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductMicroserviceApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
		};
	}

}
