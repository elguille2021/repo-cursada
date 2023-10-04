package com.example.quintaentrega1eraentreadaptadoa3capas.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.quintaentrega1eraentreadaptadoa3capas.entity.Invoice;

//public class InvoiceRepository {
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>  {
}

