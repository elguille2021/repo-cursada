package com.facturacion_Entrega.facturacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.facturacion_Entrega.facturacion.Entity.invoice_details;

import com.facturacion_Entrega.facturacion.Service.invoiceDetails_service;


import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/API/invoice_detailsBycontroller")
public class invoice_details_controller {
    @Autowired
    private invoiceDetails_service invoiceDetailsService;

    
    public ResponseEntity<Optional<invoice_details>> getInvoiceDetailsById(@PathVariable Long id) {
        Optional<invoice_details> invoiceDetails = invoiceDetailsService.findInvoiceDetailsById(id);
        if (invoiceDetails.isPresent()) {
            return ResponseEntity.ok(invoiceDetails);
        } else {
            return ResponseEntity.notFound().build();

        }
    }

    
    public ResponseEntity<Iterable<invoice_details>> getInvoiceDetails() {
        return ResponseEntity.ok(invoiceDetailsService.findAll());
    }
}
