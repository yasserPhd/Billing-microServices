package com.inventory.demo.mappers;






import org.mapstruct.Mapper;

import com.inventory.demo.dto.ProductRequestDTO;
import com.inventory.demo.dto.ProductResponseDTO;
import com.inventory.demo.entities.Product;

@Mapper(componentModel="spring")
public interface ProductMapper {
	Product fromProductRequestDTO(ProductRequestDTO productRequestDTO); 
	ProductResponseDTO fromProduct(Product product);
	

}



