package com.billing.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billing.demo.DTO.InvoiceRequestDTO;
import com.billing.demo.DTO.InvoiceResponseDTO;
import com.billing.demo.entities.Customer;
import com.billing.demo.entities.Invoice;
import com.billing.demo.entities.Product;
import com.billing.demo.entities.ProductItem;
import com.billing.demo.mappers.InvoiceMapper;
import com.billing.demo.openFeign.CustomerRestClient;
import com.billing.demo.openFeign.InventoryRestClient;
import com.billing.demo.repositories.InvoiceRepository;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	private InvoiceRepository invoiceRepository;
	private InvoiceMapper invoiceMapper;
	private CustomerRestClient customerRestClient;
	private InventoryRestClient inventoryRestClient;
	
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper,
			CustomerRestClient customerRestClient,InventoryRestClient inventoryRestClient) {
		
		this.invoiceRepository = invoiceRepository;
		this.invoiceMapper = invoiceMapper;
		this.customerRestClient = customerRestClient;
		this.inventoryRestClient= inventoryRestClient;
	}

	@Override
	public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
		// TODO Auto-generated method stub
	
		Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
		invoice.setDate(new Date());
		//verification du client intégrité referentielle
		Invoice savedInvoice = invoiceRepository.save(invoice);
		
		  Customer customer=customerRestClient.getCustomer(savedInvoice.getCustomerId());
		  Collection<ProductItem> productItems=invoiceRequestDTO.getProductItems();
		  savedInvoice.setCustomer(customer);
		  savedInvoice.setProductItems(productItems);
		 
		return invoiceMapper.fromInvoice(savedInvoice);
	}

	@Override
	public InvoiceResponseDTO getInvoice(long id) {
		// TODO Auto-generated method stub
		Invoice invoice=invoiceRepository.getById(id);
		Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
		invoice.setCustomer(customer);
		//Collections<Product> products=inventoryRestClient.getProductById(invoice.getProductId());
		InvoiceResponseDTO invoiceReponse= invoiceMapper.fromInvoice(invoice);
		//invoiceReponse.setProduct(product);
		return invoiceReponse;
	}

	@Override
	public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		List<Invoice> invoices=invoiceRepository.findByCustomerId(customerId);
		for(Invoice invoice:invoices)
		{
			Customer customer= customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
		}
		List<InvoiceResponseDTO> invoiceDTOS=invoices.stream()
				.map(invoice-> invoiceMapper.fromInvoice(invoice))
				.collect(Collectors.toList());
		return invoiceDTOS;
	}

	@Override
	public List<InvoiceResponseDTO> AllInvoices() {
		
		// TODO Auto-generated method stub
		
		List<Invoice> invoices=invoiceRepository.findAll();
		for(Invoice invoice:invoices)
		{
			Customer customer= customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
			
			
		}
		return invoices.stream()
				.map(invoice-> invoiceMapper.fromInvoice(invoice))
				.collect(Collectors.toList());
	}

}
