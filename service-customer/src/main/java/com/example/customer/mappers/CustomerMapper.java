package com.example.customer.mappers;

import org.mapstruct.Mapper;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.entities.Customer;

@Mapper(componentModel="spring")
public interface CustomerMapper {
	
	public CustomerResponseDTO CustomerToCustomerResponseDTO(Customer customer);
	public Customer CustomerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
	

}
