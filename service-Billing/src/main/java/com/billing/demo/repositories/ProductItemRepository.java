package com.billing.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.demo.entities.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, String>{
    
	
	
}
