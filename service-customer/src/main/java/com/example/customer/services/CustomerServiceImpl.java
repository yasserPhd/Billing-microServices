package com.example.customer.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.entities.Customer;
import com.example.customer.mappers.CustomerMapper;
import com.example.customer.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
  
	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper ;
	
	

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		// TODO Auto-generated method stub
		Customer customer= new Customer();
		customer=customerMapper.CustomerRequestDTOToCustomer(customerRequestDTO);
		Customer saveCustomer=customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = customerMapper.CustomerToCustomerResponseDTO(saveCustomer);
		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO getCustomer(String id) {
		// TODO Auto-generated method stub
		Customer customer= customerRepository.findById(id).get();
		return customerMapper.CustomerToCustomerResponseDTO(customer);
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
		// TODO Auto-generated method stub
		Customer customer=customerMapper.CustomerRequestDTOToCustomer(customerRequestDTO);
		Customer updatedCustomer=customerRepository.save(customer);
		return customerMapper.CustomerToCustomerResponseDTO(updatedCustomer);
	}

	@Override
	public List<CustomerResponseDTO> listCustomers() {
		// TODO Auto-generated method stub
		List<Customer> list=customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOS=list.stream()
				.map(cust -> customerMapper.CustomerToCustomerResponseDTO(cust))
				.collect(Collectors.toList());
		return customerResponseDTOS;
	}

}
