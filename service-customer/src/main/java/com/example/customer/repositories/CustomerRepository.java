package com.example.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	

}
