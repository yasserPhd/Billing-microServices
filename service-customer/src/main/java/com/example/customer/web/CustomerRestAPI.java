package com.example.customer.web;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.services.CustomerService;

@RestController
@RequestMapping(path="/api")
public class CustomerRestAPI {
	
	private CustomerService customerService;

	public CustomerRestAPI(CustomerService customerService) {
		this.customerService = customerService;
	} 
	@GetMapping(path="/hello")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping(path="/customers")
	public List<CustomerResponseDTO> AllCustomers()
	{
		return customerService.listCustomers();
	}
	@PostMapping(path="/customers")
	public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) 
	{
		customerRequestDTO.setId(UUID.randomUUID().toString());
		return customerService.save(customerRequestDTO);
	}
	
	@GetMapping(path="/customers/{id}")
	public CustomerResponseDTO getCustomerById(@PathVariable String id)
	{
		return  customerService.getCustomer(id);
	}

}
