package com.billing.demo.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.demo.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
    
	List<Invoice> findByCustomerId(String customerId);
	
}
