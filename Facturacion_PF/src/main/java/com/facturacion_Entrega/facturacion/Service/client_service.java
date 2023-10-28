package com.facturacion_Entrega.facturacion.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.facturacion_Entrega.*;
import com.facturacion_Entrega.facturacion.Entity.client;
//import com.facturacion_Entrega.facturacion.Repository.cliente_repo;
//import com.facturacion_Entrega.*;
import com.facturacion_Entrega.facturacion.Repository.cliente_repo;

@Service
public class client_service {

    @Autowired
    private cliente_repo clientRepository;

    public client save(client client) {
        return clientRepository.save(client); //aqui es variables
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Iterable<client> findAll() {
        return clientRepository.findAll();

    }
}


// @Service
// public class client_service {
//     @Autowired
//     private cliente_repo clientRepository;  //aqui si apunra a  la clase cliente_rapo

//     public client save(client Client) {
//        return cliente_repo.save(Client);  / por eso no salia porque aqui debia retornar una variable No apunta a la clase cliente_repo
//     }  //aqui se nombra clienteRepository(que es una variable) no la clase cliente_repo 

//     public void delete(Long id) {
//         clientRepository.deleteById(id);
//     }

//     public Optional<client> findClientById(Long id) {
//         return clientRepository.findById(id);
//     }

//     public Iterable<client> findAll() {
//         return clientRepository.findAll();

//     }
// }

