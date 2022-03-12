package com.inventory.demo.dto;

import javax.persistence.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ProductRequestDTO {

	private String name;
	private double price;
}
