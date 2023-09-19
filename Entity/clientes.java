package com.coderhouse.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// public class clientes {
//     public static void main(String[] args) {
//         //se crean los objetos
//     }
// }
// //se crean los metodos y atributos de la clase y los getter / setter 


//NOTA EN SPRING NO SE PONE EL MAIN ESTE YA LO TIENE PORQUE SPRING LO ASUME 
//EN SPRING SE TRABAJA ASI:  (VAMOS A MAPEAR NUESTRA CLASE)  

// LOGICA DE LA APLICACION  ---del MVC donde van las clases que accionen la applicación
 
@Entity
@Table(name = "CLIENTES")
public class clientes {

  public clientes() {   //CONSTRUCTOR   
    super();              //y super hace ref al constructor padre de entity
  }
@Column(name = "ID")
  private Integer id;           //numeros no es String  asi que donde diga  id String ahora es long que guarda 8 bytes 4 mas que un int

  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "APELLIDO")
  private String apellido;    //los strings en los querys son varchar pero en clases son String

  @Column(name = "NOMBRE_DOCUMENTO")
  private String nombredocumento;

  //Getter y Setters
public Integer getId() {    //mas bien si es Integer en vez de long porque en la bd esta como int no long
    return id;
}

public void setId(Integer id) {
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

public String getNombredocumento() {   //recordar que el nombre del get y set puede llamarse como queramos
    return nombredocumento;
}

public void setNombredocumento(String nombredocumento) {
    this.nombredocumento = nombredocumento;
}

  
}

//(ASI NUESTRA CLASE YA ESTÁ MAPEADA AHORA FALTA ENLAZARLA AL DAO O que DAO se enlace a la BD por medio de los objetos de aqui)

//En spring ya no se pone asi el constructor  sino como lo pusimos arriba

// public Cliente(String nombre, String apellido){

//     super();
//     this.nombre=nombre;
//     this.apellido=apellido; ..etc
// }

