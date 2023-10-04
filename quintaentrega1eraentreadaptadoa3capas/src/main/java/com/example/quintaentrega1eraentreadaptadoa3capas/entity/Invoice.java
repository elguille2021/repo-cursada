package com.example.quintaentrega1eraentreadaptadoa3capas.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//import.jakarta.persistence.*;
@Entity
@Table(name="invoice") //no se llama invoice_details no confundir esa es otra tabla

public class Invoice { //  una cosa es el nombre de la clase en java y otra es el que aparece en la tabla o diagramas E-r
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "create_at")
    private Date createdAt;
    @Column(name = "total")
    private Double total;       //el orden en los campos salta porque aqui  a diferencia de la Tabla Client o clients ya hay mas relaciones  es decir de  pk y fk con  la 3er table invoice_details

    @ManyToOne   //muchos a 1     esta tabla es muchos (porque Client es 1 a muchos o conectando a esta tabla) porque JPA con hibernate traduce clases java a tablas sql
    @JoinColumn(columnDefinition = "client_id")
    private Client client; // esta es la relacion de regreso  de la  id pk A la tabla Clients en el diagrama  (Client aqui)

    @OneToMany(mappedBy = "invoice")  //al campo invoice de tabla invoice_details
    private List<InvoiceDetails> invoiceDetails;  //y esta es la 2da relacion  ya a otra tabla  de fk o client_id a la 3er tabla invoice_details

//constructores uno vacío y uno con parámetros   El client es la variable que representa el id y es de tipo Client
public Invoice(){}

public Invoice(Long id, Date createdAt, Double total, Client client, List<InvoiceDetails> invoiceDetails) {
    this.id = id;
    this.createdAt = createdAt;
    this.total = total;
    this.client = client;
    this.invoiceDetails = invoiceDetails;
}

//metodos de acceso a datos getter-setter
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Date getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
}

public Double getTotal() {
    return total;
}

public void setTotal(Double total) {
    this.total = total;
}

public Client getClient() {
    return client;
}

public void setClient(Client client) {
    this.client = client;
}

public List<InvoiceDetails> getInvoiceDetails() {
    return invoiceDetails;
}

public void setInvoiceDetails(List<InvoiceDetails> invoiceDetails) {
    this.invoiceDetails = invoiceDetails;
}





}
