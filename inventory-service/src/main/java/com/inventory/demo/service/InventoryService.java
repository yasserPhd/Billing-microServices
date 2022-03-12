package com.inventory.demo.service;

import java.util.List;

import com.inventory.demo.dto.ProductRequestDTO;
import com.inventory.demo.dto.ProductResponseDTO;

public interface InventoryService {
   
	public ProductResponseDTO save(ProductRequestDTO productRequestDTO);
	public List<ProductResponseDTO> allProducts();
	public ProductResponseDTO getProductById(long id);
}
