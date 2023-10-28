package com.facturacion_Entrega.facturacion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion_Entrega.facturacion.Entity.products;
@Repository
public interface products_repo extends JpaRepository<products, Long> {

}

