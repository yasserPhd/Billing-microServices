package com.billing.demo.openFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.billing.demo.entities.Customer;
import com.billing.demo.entities.Product;

@FeignClient(name="INVENTORY-SERVICE")
public interface InventoryRestClient {

	@GetMapping("/api/products")
	List<Product> allProducts();
	
	@PostMapping("/api/products")
	Product saveProduct(@RequestBody Product product);
	
	@GetMapping("/api/products/{id}")
	Product getProductById(@PathVariable long id);
	
}
