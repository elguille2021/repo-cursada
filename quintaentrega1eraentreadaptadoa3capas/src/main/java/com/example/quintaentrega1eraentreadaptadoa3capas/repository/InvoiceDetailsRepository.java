package com.example.quintaentrega1eraentreadaptadoa3capas.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.quintaentrega1eraentreadaptadoa3capas.entity.InvoiceDetails;

//public class InvoiceDetailsRepository {
@Repository
  public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Long>{  
}
