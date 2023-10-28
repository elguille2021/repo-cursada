package com.facturacion_Entrega.facturacion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion_Entrega.facturacion.Entity.invoices;

@Repository
public interface invoice_repo extends JpaRepository<invoices, Long> {
}