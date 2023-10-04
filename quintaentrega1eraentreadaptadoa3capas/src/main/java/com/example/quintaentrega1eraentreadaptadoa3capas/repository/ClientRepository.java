package com.example.quintaentrega1eraentreadaptadoa3capas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.quintaentrega1eraentreadaptadoa3capas.*;
import com.example.quintaentrega1eraentreadaptadoa3capas.entity.Client;

@Repository
//public class ClientRepository {  //aqui va la interfase  con ella hereda los metodos del repositorio que hace posible el no tener que usar ni el schema ni el data.sql 
  public interface ClientRepository extends JpaRepository<Client, Long>{

  }  

