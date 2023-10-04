package com.example.quintaentrega1eraentreadaptadoa3capas.controller;

import com.example.quintaentrega1eraentreadaptadoa3capas.entity.Invoice;
import com.example.quintaentrega1eraentreadaptadoa3capas.service.InvoiceService;

import org.springframework.http.MediaType;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Optional<Invoice>> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceService.findInvoiceById(id);
        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Iterable<Invoice>> getInvoices() {
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
        try {
            Invoice createInvoice = invoiceService.save(invoice);
            return ResponseEntity.ok(createInvoice);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    
}
