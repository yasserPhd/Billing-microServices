package com.example.customer.services;

import java.util.List;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;

public interface CustomerService {
   public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
   public CustomerResponseDTO getCustomer(String id);
   public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
   List<CustomerResponseDTO> listCustomers();
   
}
