package com.billing.demo.mappers;

import org.mapstruct.Mapper;

import com.billing.demo.DTO.InvoiceRequestDTO;
import com.billing.demo.DTO.InvoiceResponseDTO;
import com.billing.demo.entities.Invoice;
import com.billing.demo.entities.Product;
import com.billing.demo.entities.ProductItem;

@Mapper(componentModel="spring")
public interface InvoiceMapper {
	Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO); 
	InvoiceResponseDTO fromInvoice(Invoice invoice);
	Invoice fromInvoiceResponseDTO(InvoiceResponseDTO invoiceResponseDTO);
	ProductItem fromProduct(Product product);
	
	

}
