package com.example.quintaentrega1eraentreadaptadoa3capas.controller;
import com.example.quintaentrega1eraentreadaptadoa3capas.entity.Product;
import com.example.quintaentrega1eraentreadaptadoa3capas.service.ProductService;

import org.springframework.http.MediaType;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/", produces = { "application/json" })
    public ResponseEntity<Iterable<Product>> getProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Product> saveProduct(@RequestBody Product client) {
        try {
            Product createdProduct = productService.save(client);
            return ResponseEntity.ok(createdProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    
}
