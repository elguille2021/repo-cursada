package com.example.quintaentrega1eraentreadaptadoa3capas.controller;

import com.example.quintaentrega1eraentreadaptadoa3capas.entity.InvoiceDetails;
import com.example.quintaentrega1eraentreadaptadoa3capas.service.InvoiceDetailsService;

import org.springframework.http.MediaType;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/invoice-details")
public class InvoiceDetailsController {
    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<Optional<InvoiceDetails>> getInvoiceDetailsById(@PathVariable Long id) {
        Optional<InvoiceDetails> invoiceDetails = invoiceDetailsService.findInvoiceDetailsById(id);
        if (invoiceDetails.isPresent()) {
            return ResponseEntity.ok(invoiceDetails);
        } else {
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping(value = "/", produces = { "application/json" })
    public ResponseEntity<Iterable<InvoiceDetails>> getInvoiceDetails() {
        return ResponseEntity.ok(invoiceDetailsService.findAll());
    }

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<InvoiceDetails> saveInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
        try {
            InvoiceDetails createdInvoiceDetails = invoiceDetailsService.save(invoiceDetails);
            return ResponseEntity.ok(createdInvoiceDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
}
