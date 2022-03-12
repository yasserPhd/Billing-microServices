package com.billing.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.billing.demo.DTO.InvoiceRequestDTO;
import com.billing.demo.DTO.InvoiceResponseDTO;
import com.billing.demo.entities.Invoice;
import com.billing.demo.entities.Product;
import com.billing.demo.entities.ProductItem;
import com.billing.demo.mappers.InvoiceMapper;
import com.billing.demo.openFeign.InventoryRestClient;
import com.billing.demo.repositories.ProductItemRepository;
import com.billing.demo.services.InvoiceService;
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ServiceBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBillingApplication.class, args);
	}

	@Bean
	 CommandLineRunner commandLineRunner(InvoiceService invoiceService, ProductItemRepository productItemRepository,
			 InvoiceMapper invoiceMapper, InventoryRestClient inventoryRestClient)
	 {
		return args ->
		{	
			
			/*
			 * InvoiceResponseDTO savedInvoice=invoiceService.getInvoice(18L); Invoice
			 * invoice=invoiceMapper.fromInvoiceResponseDTO(savedInvoice); Product product=
			 * inventoryRestClient.getProductById(1L); productItemRepository.save(new
			 * ProductItem(null,3L,product.getName(), product.getPrice(), 5,invoice));
			 */
			
			/*
			 * InvoiceRequestDTO invoiceReqDTo = new InvoiceRequestDTO (new Date(),"C02",
			 * null); InvoiceResponseDTO invoiceReponse= invoiceService.save(invoiceReqDTo);
			 * 
			 * Invoice savedInvoice=invoiceMapper.fromInvoiceResponseDTO(invoiceReponse);
			 * Product product= inventoryRestClient.getProductById(2L);
			 * productItemRepository.save(new
			 * ProductItem(null,product.getId(),product.getName(), product.getPrice(), 8,
			 * savedInvoice));
			 * 
			 * Product product2= inventoryRestClient.getProductById(1L);
			 * productItemRepository.save(new
			 * ProductItem(null,product2.getId(),product2.getName(), product2.getPrice(), 3,
			 * savedInvoice));
			 */
			 
			 
			  //System.out.println("invoice content is"+savedInvoice.toString());
			 
			 
		
			//invoiceService.save(new InvoiceRequestDTO (BigDecimal.valueOf(540000),"C01",2));
			//invoiceService.save(new InvoiceRequestDTO (BigDecimal.valueOf(120000),"C02",1));
		}; 
	 }
	 
}
