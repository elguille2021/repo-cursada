package com.example.quintaentrega1eraentreadaptadoa3capas.controller;

import com.example.quintaentrega1eraentreadaptadoa3capas.entity.Client;
import com.example.quintaentrega1eraentreadaptadoa3capas.service.ClientService;

import org.springframework.http.MediaType;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.findClientById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{id}/invoices", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Optional<Client>> getClientInvoices(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findClientById(id));
    }

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Iterable<Client>> getClients() {
        return ResponseEntity.ok(clientService.findAll());

    }

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        try {
            Client createdClient = clientService.save(client);
            return ResponseEntity.ok(createdClient);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
  //aqui se generan los json y el endpoint que se prueba en postman
    
}
