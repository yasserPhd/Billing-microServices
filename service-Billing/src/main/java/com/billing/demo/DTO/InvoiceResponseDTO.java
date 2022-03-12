package com.billing.demo.DTO;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Transient;

import com.billing.demo.entities.Customer;
import com.billing.demo.entities.ProductItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data @AllArgsConstructor @NoArgsConstructor 
public class InvoiceResponseDTO {
	private long id;
	private Date date;
	private Customer customer;
	private Collection<ProductItem> ProductItems;
	
	
}
