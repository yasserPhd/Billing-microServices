package com.billing.demo.DTO;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;


import com.billing.demo.entities.Customer;
import com.billing.demo.entities.ProductItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data @AllArgsConstructor @NoArgsConstructor 
public class InvoiceRequestDTO {
	private Date date;
	private String customerId;
	private Collection<ProductItem> ProductItems;
}
