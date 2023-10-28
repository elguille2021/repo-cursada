package com.facturacion_Entrega.facturacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.facturacion_Entrega.facturacion.Entity.products;
//import com.billing.finalproject.response.ResourceNotFoundException;
import com.facturacion_Entrega.facturacion.Service.product_service;


import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("API/products")
public class Products_controller {
    @Autowired
    private product_service productService;

    
    public ResponseEntity<Optional<products>> getProductById(@PathVariable Long id) {
        Optional<products> product = productService.findProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            //throw new ResourceNotFoundException("Product not found");
        }     return ResponseEntity.notFound().build();
    }

    

     public ResponseEntity<products> saveProduct(@RequestBody products client) {
        try {
            products createdProduct = productService.save(client);
            return ResponseEntity.ok(createdProduct);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new ResourceNotFoundException("Product not created");
        }   return ResponseEntity.notFound().build(); 
    }
}
    