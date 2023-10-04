package com.example.quintaentrega1eraentreadaptadoa3capas.entity;
import java.util.List;

import jakarta.persistence.*;  //luego que tenga tiempo probaré lombook  pues con solo poner 
@Entity                       //@getters y setters y @constructors ya lo toma como tal sin necesidad de ponerlos
@Table(name="clients")   
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "docnumber")
    private String docnumber;

    @OneToMany(mappedBy = "client") //1 a Muchos  al campo cliente que en realidad es client_id de la tabla Invoice
    private List<Invoice> invoice;

    //constructores uno vacío y uno con parámetros
    public Client(){

    }
    public Client(Long id, String name, String lastname, String docnumber, List<Invoice> invoice) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
        this.invoice = invoice;
    }

    //getters-setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public String getDocnumber() {
        return docnumber;
    }
    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }
    public List<Invoice> getInvoice() {
        return invoice;
    }
    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    
}
