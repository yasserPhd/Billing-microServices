package com.inventory.demo.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.demo.dto.ProductRequestDTO;
import com.inventory.demo.dto.ProductResponseDTO;
import com.inventory.demo.service.InventoryService;

@RestController
@RequestMapping(path="/api")
public class ProductController {
	private InventoryService productService;

	public ProductController(InventoryService productService) {
		
		this.productService = productService;
	}

	@GetMapping(path="/products")
	public List<ProductResponseDTO> allProducts()
	{
		return productService.allProducts();
	}
	
	@PostMapping(path="/products")
	public ProductResponseDTO save(@RequestBody ProductRequestDTO productRequestDTO) {
		return productService.save(productRequestDTO);
	}
	
	@GetMapping(path="/products/{id}")
	public ProductResponseDTO getProduct(@PathVariable long id)
	{
		return productService.getProductById(id);
	}
}
