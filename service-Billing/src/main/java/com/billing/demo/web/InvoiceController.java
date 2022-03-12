package com.billing.demo.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.demo.DTO.InvoiceRequestDTO;
import com.billing.demo.DTO.InvoiceResponseDTO;
import com.billing.demo.services.InvoiceService;

@RestController
@RequestMapping(path="/api")
public class InvoiceController {
	
	private InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		
		this.invoiceService = invoiceService;
	}
	
	@GetMapping(path="/invoices/{id}")
	public InvoiceResponseDTO getInvoice(@PathVariable (name="id")long invoiceId)
	{
		return invoiceService.getInvoice(invoiceId);
	}
	
	@GetMapping(path="/invoicesByCustomer/{customerId}")
	public List<InvoiceResponseDTO> getInvoicesByCustomerId(@PathVariable String customerId)
	{
		return invoiceService.invoicesByCustomerId(customerId);
	}
	
	@PostMapping(path="/invoices")
	public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO)
	{
		return invoiceService.save(invoiceRequestDTO);
	}
	
	@GetMapping(path="/invoices")
	public List<InvoiceResponseDTO> invoices()
	{
		return invoiceService.AllInvoices();
	}
	
	
	

}
