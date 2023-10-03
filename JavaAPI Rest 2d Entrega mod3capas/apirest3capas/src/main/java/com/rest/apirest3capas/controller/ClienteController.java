package com.rest.apirest3capas.controller;

import java.util.Optional;

//import org.apache.catalina.connector.Response;
//import org.apache.tomcat.util.http.parser.MediaType;

import org.springframework.beans.factory.annotation.Autowired; //--no hace falta
import org.springframework.http.MediaType; //ESTE FALTABA  PARA EL APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.apirest3capas.entity.ClienteApiRest_GuilleSerrano;
//import com.rest.apirest3capas.entity.ClienteApiRest_GuilleSerrano.ClienteEntity;
import com.rest.apirest3capas.service.ClienteService;
 //@Service  No va aqui sino en service aunque tampoco hace falta allá porque se quita el autowired aqui ya que controller hace referencia a service y esta a la interfaz que proviene de repositorio y como puse en service  y no puedo hacer un cableado automático @Autowired a una interfaz
@RestController
@RequestMapping("/api/clienterest") // este será el endpoint o url que usamos para las pruebas en postman
 public class ClienteController {
    @Autowired
   
    private ClienteService clienteService;  //el primer parametro es la clase y el 2do es la variable a la que se relaciona 

//Métodos
@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})//"application/json") // esta linea no sirvió {MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<Optional<ClienteApiRest_GuilleSerrano>>findById(@PathVariable Long id) {
    //return ResponseEntity.ok(clienteService.findById(id));
    Optional<ClienteApiRest_GuilleSerrano> cliente=clienteService.findById(id);
                                     
    if(cliente.isPresent()) {          //con Optional obtenemos el cliente 
        return ResponseEntity.ok(cliente);  //y en caso de que esté devuelve una respuesta 200 en formato json 
    } else {  //y sino que no lo encontró y pone un error 404
        return ResponseEntity.notFound().build();  
    }
} //era por esta llave que faltaba cerrar que daba The annotation @PostMapping is disallowed for this location

     @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})//"application/json",  consumes="application/json") //{MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<ClienteApiRest_GuilleSerrano> save(@RequestBody ClienteApiRest_GuilleSerrano cliente) {
        try {
            ClienteApiRest_GuilleSerrano clienteSaved = clienteService.save(cliente);
            return ResponseEntity.ok(clienteSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }



    }



}
 
/*SE QUITO EL Autowired porque ya viene de una interfaz no hace falta volver a instanciar  pues UNA INTERFAZ no lleva Autowired PORQUE RECORDAR QUE UNA INTERFAZ NO SE PUEDE INSTANCIAR 
 * es decir:
 * Ya que controller llama por decirlo a ClienteService y este al repositorio o ClienteRepository  PERO ClienteRepository YA ESTA INSTANCIADO CON Autowired en ClienteService
entonces ya no hace falta volver a instanciarla desde el controller  a Repository   porque Repository NO ES UNA CLASE 
SINO es una INTERFAZ  

QUE EN REALIDAD Hereda de o es JPARepository(una de las interfaz fuertes de Spring) REALMENTE LO QUE CREA LA TABLA CON SQL Y JPA con HIBERNATE LO TRADUCE de clases a tablas en la consola web


*/
  


/*Create GET, POST, and DELETE endpoints in Spring Boot with IntelliJ IDEA

Create GET, POST, and DELETE endpoints in Spring Boot with IntelliJ IDEA - YouTube---Sustituir APPLICATION_JSON_VALUE por "application/json""

Brandan Jones
28.4 k suscriptores 

The annotation @PostMapping is disallowed for this location  
era por una llave */