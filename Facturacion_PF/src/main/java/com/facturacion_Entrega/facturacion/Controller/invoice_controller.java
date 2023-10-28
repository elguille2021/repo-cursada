package com.facturacion_Entrega.facturacion.Controller;

import com.facturacion_Entrega.facturacion.Entity.invoices;
//import com.facturacion_Entrega.facturacion.*;
import com.facturacion_Entrega.facturacion.Service.invoice_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("API/invoice")
public class invoice_controller {
    @Autowired
    private invoice_service invoiceService;

    
    public ResponseEntity<Optional<invoices>> getInvoiceById(@PathVariable Long id) {
        Optional<invoices> invoice = invoiceService.findInvoiceById(id);
        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice);
        } else {
           // throw new ResourceNotFoundException("Invoice not found");
        }   return ResponseEntity.notFound().build();//--dejar este en vez del throw
    }

    
    public ResponseEntity<Iterable<invoices>> getInvoices() {
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    
    public ResponseEntity<invoices> saveInvoiceWithDetails(@RequestBody invoices invoice) {
        try {
            var response = invoiceService.saveWithDetails(invoice);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new ResourceNotFoundException("Invoice not created");
        }   return ResponseEntity.notFound().build();
    }

}