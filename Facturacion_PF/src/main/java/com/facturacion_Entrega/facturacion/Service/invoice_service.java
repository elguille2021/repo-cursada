package com.facturacion_Entrega.facturacion.Service;

import com.facturacion_Entrega.facturacion.Entity.client;
import com.facturacion_Entrega.facturacion.Entity.invoices;
import com.facturacion_Entrega.facturacion.Entity.invoice_details;

//import com.facturacion_Entrega.facturacion.Repository.invoiceDetails_repo;  es el repo de invoice_repo Y no de invoice_details
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.facturacion_Entrega.facturacion.Repository.invoice_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class invoice_service {

    @Autowired
    private invoice_repo invoiceRepository;
    @Autowired
    private client_service clientService;
    @Autowired
    private product_service productService;  //faltaba(ya se hizo) crear el servicio de product_service

    public invoices save(invoices invoice) {
        return invoiceRepository.save(invoice);
    }

    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    public Optional<invoices> findInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public Iterable<invoices> findAll() {
        return invoiceRepository.findAll();
    }

    public invoices saveWithDetails(invoices invoice) {  //apuntan a las clases invoice y client 
        Long clientId = invoice.getClient().getClientId();
        Optional<client> clientOptional = clientService.findClientById(clientId);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://worldclockapi.com/api/json/utc/now",
                String.class);

        Date currentDate;

        if (response.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode root = objectMapper.readTree(response.getBody());
                String currentDateString = root.get("currentDateTime").asText();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                currentDate = simpleDateFormat.parse(currentDateString);

                // Convert java.util.Date to java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

                invoice.setCreatedAt(sqlDate);
            } catch (Exception e) {
                currentDate = new Date();
            }
        } else {
            currentDate = new Date();
        }
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        invoice.setCreatedAt(sqlDate);
        if (clientOptional.isEmpty())
            throw new RuntimeException("The client not exists");

        client client = clientOptional.get();
        invoice.setClient(client);

        int totalProduct = 0;
        var details = invoice.getInvoiceDetails();
        var aux = 0d;
        if (details != null)
            for (invoice_details id : details) {
                Long productId = id.getProduct().getProductId();
                Integer amount = id.getAmount(); //no es Long sino integer
//daba error porque aun no se habian creado los servicios de la clase product_service 
                var newStockWithSell = productService.updateStockWithSell(productId, amount);
                if (newStockWithSell < 0)
                    throw new RuntimeException("There is not enough stock for the product with ID " + productId);

                id.getProduct().setStock(newStockWithSell);

                id.setPrice(productService.getProductPrice(id.getProduct().getProductId()) * id.getAmount());
                aux += id.getPrice();
                totalProduct += amount;
            }
        invoice.setTotalProduct(totalProduct);
        invoice.setTotal(aux);

        return save(invoice);
    }
}