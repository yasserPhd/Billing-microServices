package com.billing.demo.services;

import java.util.List;

import com.billing.demo.DTO.InvoiceRequestDTO;
import com.billing.demo.DTO.InvoiceResponseDTO;

public interface InvoiceService {
  public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
  public InvoiceResponseDTO getInvoice(long id);
  public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);
  public List<InvoiceResponseDTO> AllInvoices();
  
 
}
