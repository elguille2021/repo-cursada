package com.rest.apirest3capas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.apirest3capas.entity.ClienteApiRest_GuilleSerrano;
// com.rest.apirest3capas.entity.ClienteApiRest_GuilleSerrano.ClienteEntity;
import com.rest.apirest3capas.repository.ClienteRepository;

@Service //--no hace falta poner esta anotation si se quita el Autowired en ClienteController ya que Repository es una interfaz y no puedo hacer un cableado automático @Autowired a una interfaz
public class ClienteService {
@Autowired  //crea una instancia sin necesidad de instanciar la clase
private ClienteRepository clienteRepository;  //el primer parametro es la clase y el 2do es la variable a la que se relaciona 


//Aquí en el service van las funciones que se van a crear para utilizar el repositorio que se van a comunicar con la bd

public ClienteApiRest_GuilleSerrano save(ClienteApiRest_GuilleSerrano cliente){
    return clienteRepository.save(cliente);   //existById -- devuelve un true/false o comprueba si existe un dato por el id que le paso  y count()cuenta los registros en una bd
}                                                //metodos deprecados

//optional  es un tipo de condicional que comprueba si existe el id
public Optional<ClienteApiRest_GuilleSerrano>findById(Long id){
    return clienteRepository.findById(id);
}
}
