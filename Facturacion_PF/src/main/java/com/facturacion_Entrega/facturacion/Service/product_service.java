package com.facturacion_Entrega.facturacion.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion_Entrega.facturacion.Entity.products;
import com.facturacion_Entrega.facturacion.Repository.products_repo;

@Service
public class product_service {
    @Autowired
    private products_repo productRepository;

    public products save(products product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<products> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Iterable<products> findAll() {
        return productRepository.findAll();
    }

    public double getProductPrice(Long productId) {
        var product = productRepository.findById(productId);

        if (product.isEmpty())
            throw new RuntimeException();

        return product.get().getPrice();
    }

    public Long updateStockWithSell(Long productId, Integer amount) {//aqui estaba el error estaba amount como Long y desde invoice_details es Integer  y por eso aqui en product_service y en invoice_service en la linea 92 y 94 habia error también pero ya corrigiendo aqui queda en el otro también resuelto
        var product = productRepository.findById(productId);
        if (product.isEmpty())
            throw new RuntimeException();

        product.get().setStock(product.get().getStock() - amount);
        productRepository.save(product.get());

        return product.get().getStock(); 

    }
}