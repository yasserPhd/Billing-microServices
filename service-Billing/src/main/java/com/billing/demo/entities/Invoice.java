package com.billing.demo.entities;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @AllArgsConstructor @NoArgsConstructor 

public class Invoice {
	@Id 
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	private Date date;
	private String customerId;
	@Transient
	private Customer customer;
	@OneToMany(mappedBy = "invoice")
	private Collection<ProductItem> ProductItems;
	
	

}
