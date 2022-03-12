package com.inventory.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.inventory.demo.dto.ProductRequestDTO;
import com.inventory.demo.entities.Product;
import com.inventory.demo.service.InventoryService;
@EnableEurekaClient
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(InventoryService productService) {
		return args -> {
			/*
			 * productService.save(new ProductRequestDTO("Ordi HP 878", 87000));
			 * productService.save(new ProductRequestDTO("Ordi Mac bokk", 120000));
			 * productService.save(new ProductRequestDTO("Imprimante Epson", 25000));
			 */
		};
	}

}
