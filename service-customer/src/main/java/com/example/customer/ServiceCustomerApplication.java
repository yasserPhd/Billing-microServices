package com.example.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.services.CustomerService;
@EnableEurekaClient
@SpringBootApplication
public class ServiceCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCustomerApplication.class, args);
		
		
	}
	
	@Bean
	CommandLineRunner start(CustomerService customerService )
	{
		return args -> 
		{
			/*
			 * customerService.save(new
			 * CustomerRequestDTO("C01","Yasser","Yasser@gmail.com"));
			 * customerService.save(new CustomerRequestDTO("C02","Imed","Imed@gmail.com"));
			 */
		};
	}
     
	
}
