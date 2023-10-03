package com.rest.apirest3capas.entity;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

//import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

//public class ClienteApiRest_GuilleSerrano {
    @Entity
    @Table(name = "CLIENTE")
    public class ClienteApiRest_GuilleSerrano {  //puse la clase del ejemplo del profe ClienteEntity
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(name = "NOMBRE")
        private String nombre;
    
        @Column(name = "APELLIDO")
        private String apellido;

     //@Temporal(TemporalType.DATE)
    // @JsonFormat(pattern = "MM/dd/yyyy",shape=Shape.STRING)
     //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy" )
     //@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
     //@DateTimeFormat(pattern = "yyyy-MM-dd")
     @CreationTimestamp
        @Column(name = "FECHA_D_NACIMIENTO", nullable = false, updatable = false)
        //@notnull
        private Date fechnac;
    
        //contructores
        public ClienteApiRest_GuilleSerrano() {  //no es ClienteEntity
        }

        public ClienteApiRest_GuilleSerrano(Long id, String nombre, String apellido, Date fechnac) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechnac = fechnac;
        }


        //getters-setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public Date getFechnac() {
            return fechnac;
        }

        public void setFechnac(Date fechnac) {
            this.fechnac = fechnac;
        }
        
}



/*dentro de java\apirest\ --donde esta el main o el Aplication.java se crean todas las carpetas --esto es importante para crear bien el proyecto

creamos las carpetas

entity ---este primero 1
service --luego este   2
controller       
repository

y ya en orden de programar programamos primero
1 la entity  con ClienteApiRest_GuilleSerrano.java
2 el repository --donde hacemos la interfaz con entity
3 Service --//en el service van las funciones que se van a crear para utilizar el repositorio que se van a comunicar con la bd



*/