package com.billing.demo.openFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.billing.demo.entities.Customer;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

	@GetMapping("/api/customers/{id}") 
	Customer getCustomer(@PathVariable(name="id") String id);
	
	@GetMapping("/api/customers")
	List<Customer> allCustomers();
}
