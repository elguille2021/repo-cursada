package com.rest.apirest3capas.repository;

import org.springframework.data.jpa.repository.JpaRepository;  //Jpa es una de las interfaces que tiene Spring  otra es CrudRepository, ListCrudRepository, y ListJpaRepository que nos devuelve una lista de Array list
import org.springframework.stereotype.Repository;

import com.rest.apirest3capas.entity.ClienteApiRest_GuilleSerrano;   //con la interface conectamos  con las propiedades o heredamos (atributos y metodos) de esa clase  de ClienteApiRest
@Repository
public interface ClienteRepository extends JpaRepository<ClienteApiRest_GuilleSerrano, Long>{   //este se conecta como 1er parametro a la clase entity y como segundo parametro al tipo de dato del cual va es el id principal o pk  de esa clase
    
}
 //las notaciones en java son muy importantes como @repository porque es lo que le da indentidad a cada capa