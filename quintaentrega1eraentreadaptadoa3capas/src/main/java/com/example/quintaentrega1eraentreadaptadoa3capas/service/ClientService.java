package com.example.quintaentrega1eraentreadaptadoa3capas.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quintaentrega1eraentreadaptadoa3capas.entity.Client;

import com.example.quintaentrega1eraentreadaptadoa3capas.repository.ClientRepository;

@Service      //invoca al repositorio que es el que se comunica con la bd y también el que finalmente usa jparepository para hacer el trabajo back de las querys sql
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();

    }  
}
