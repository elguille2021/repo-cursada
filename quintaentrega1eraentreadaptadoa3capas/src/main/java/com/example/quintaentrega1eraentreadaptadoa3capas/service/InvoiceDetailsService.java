package com.example.quintaentrega1eraentreadaptadoa3capas.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quintaentrega1eraentreadaptadoa3capas.entity.InvoiceDetails;
import com.example.quintaentrega1eraentreadaptadoa3capas.repository.InvoiceDetailsRepository;

//public class InvoiceDetailsService {
  @Service
public class InvoiceDetailsService {

    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    public InvoiceDetails save(InvoiceDetails invoiceDetails) {
        return invoiceDetailsRepository.save(invoiceDetails);
    }
                                         
    public void delete(Long id) {     //ahorita usé delete pero pude ponerle al metodo create id con createById
        invoiceDetailsRepository.deleteById(id);
    }

    public Optional<InvoiceDetails> findInvoiceDetailsById(Long id) {
        return invoiceDetailsRepository.findById(id);
    }

    public Iterable<InvoiceDetails> findAll() {
        return invoiceDetailsRepository.findAll();
    }  
}
