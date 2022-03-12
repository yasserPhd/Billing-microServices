package com.inventory.demo.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ProductResponseDTO {
	private Long id;
	private String name;
	private double price;
}
