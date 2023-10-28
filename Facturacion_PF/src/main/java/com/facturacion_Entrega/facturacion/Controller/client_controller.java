package com.facturacion_Entrega.facturacion.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facturacion_Entrega.facturacion.Entity.*;
//import com.facturacion_Entrega.*;
import com.facturacion_Entrega.facturacion.Service.client_service;      

@RestController
@RequestMapping("API/client")
public class client_controller {

    @Autowired
    private client_service clientService;

    
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Optional<client>> getClientById(@PathVariable Long id) {
        Optional<client> client = clientService.findClientById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client);
        } else {
            //throw new ResourceNotFoundException("Client not found with ID: " + id);
        }    return ResponseEntity.notFound().build();
    }

    
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Iterable<client>> getClients() {
        return ResponseEntity.ok(clientService.findAll());

    }

    
    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<client> save(@RequestBody client client) {
        try {
            client clientSaved = clientService.save(client);
            return ResponseEntity.ok(clientSaved);
        } catch (Exception e) {
            e.printStackTrace();
           // throw new ResourceNotFoundException("Client not saved");
        }    return ResponseEntity.notFound().build();
    }
}