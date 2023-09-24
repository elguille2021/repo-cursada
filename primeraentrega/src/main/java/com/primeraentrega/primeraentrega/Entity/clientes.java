package com.primeraentrega.primeraentrega.Entity;
//import javax.persistence.*;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name="client")
public class clientes {
    @Id// apunta a los imports de persistence.Column    NOTA: el error de @id era por que va con I mayuscula 
@GeneratedValue(strategy = GenerationType.IDENTITY)//y este a persistence.GeneratedValue

//@Column(name="id")   /*si pongo un colum en @ id DA  Web server failed to start. Port 5000 was already in use. Action: Identify and stop the process that's listening on port 5000 or configure this application to listen on another port.*/
private int id;   //campos de la bd traducidos a lenguaje java

//@Column(name="name")  
private String name;

@Column(name="last_name")
private String lastname;

@Column(name="doc_number")
private int doc_number; //era int no string y si cambia aqui cambia en todo en ese campo


//metodo constructor vacio y con datos (basta con el que tiene argumentos)--parametros es si los  recibiera desde otra clase
public clientes(){}   //cada this apunta a la clase y al dato de los objetos (pero en este caso de cada campo de la bd) ej cliente.id o al p1.getid()  si p1 fuera un objeto que aqui no aplica

public clientes(int id, String name, String lastname, int doc_number) { //int por string  
    this.id = id;       
    this.name = name;
    this.lastname = lastname;
    this.doc_number = doc_number;
}


//construyendo los GETTERS Y SETTERS O metodos de acceso  para posteriormente acceder a los datos (en este caso a los datos de insertados con los scripts sql)

public int getId() {
    return id;
}



public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getLastname() {
    return lastname;
}

public void setLastname(String lastname) {
    this.lastname = lastname;
}

public int getDoc_number() {  //int por string
    return doc_number;
}

public void setDoc_number(int doc_number) { //int por string
    this.doc_number = doc_number;
}


}
