package com.facturacion_Entrega.facturacion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion_Entrega.facturacion.Entity.client;

@Repository
public interface cliente_repo extends JpaRepository<client, Long> {

}

