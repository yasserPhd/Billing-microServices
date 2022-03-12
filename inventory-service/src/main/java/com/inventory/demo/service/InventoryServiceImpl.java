package com.inventory.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.demo.dto.ProductRequestDTO;
import com.inventory.demo.dto.ProductResponseDTO;
import com.inventory.demo.entities.Product;
import com.inventory.demo.mappers.ProductMapper;
import com.inventory.demo.repositories.ProductRepository;

import lombok.Data;
@Data
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
   private ProductRepository productRepository;
   private ProductMapper productMapper;
   
   
   public InventoryServiceImpl(ProductRepository productRepository, ProductMapper productMapper ) {
		
		this.productRepository = productRepository;
		this.productMapper=productMapper;
	}
   
	@Override
	public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
		// TODO Auto-generated method stub
		Product product = productMapper.fromProductRequestDTO(productRequestDTO);
		Product savedProduct= productRepository.save(product);
		return productMapper.fromProduct(savedProduct);
	}

	@Override
	public List<ProductResponseDTO> allProducts() {
		// TODO Auto-generated method stub
		List<Product> products= productRepository.findAll();
		List<ProductResponseDTO> productsResponseDTO= products.stream().map(prod-> productMapper.fromProduct(prod))
		.collect(Collectors.toList());
		return productsResponseDTO;
	}

	@Override
	public ProductResponseDTO getProductById(long id) {
		// TODO Auto-generated method stub
		Product product=productRepository.findById(id).get();
		
		return productMapper.fromProduct(product);	}

	

}
