package com.facturacion_Entrega.facturacion.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.facturacion_Entrega.*;

import com.facturacion_Entrega.facturacion.Entity.invoice_details;

import com.facturacion_Entrega.facturacion.Repository.invoiceDetails_repo;

@Service
public class invoiceDetails_service {

    @Autowired
    private invoiceDetails_repo invoiceDetailsRepository;

    public invoice_details save(invoice_details invoiceDetails) {
        return invoiceDetailsRepository.save(invoiceDetails);
    }

    public void delete(Long id) {
        invoiceDetailsRepository.deleteById(id);
    }

    public Optional<invoice_details> findInvoiceDetailsById(Long id) {
        return invoiceDetailsRepository.findById(id);
    }

    public Iterable<invoice_details> findAll() {
        return invoiceDetailsRepository.findAll();
    }
}
