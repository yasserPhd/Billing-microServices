package com.inventory.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
