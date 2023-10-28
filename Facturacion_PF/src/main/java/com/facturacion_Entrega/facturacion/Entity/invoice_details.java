package com.facturacion_Entrega.facturacion.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "invoice_details")
public class invoice_details {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//f:\JAVA3PrimeraEntrega\primera entrega\primeraentrega\src\main\java\com\primeraentrega\primeraentrega\Entity\Invoice_Details.java

// private Integer id;  esto no va   esta era de una tabla de la primera entrega que hice,  nada que ver  porque las relaciones de la primera entrega eran distintas  nada que ver con esta ultima entrega pero vale la aclaración para no confundirlas
//     @OneToOne
//     @Column(name = "invoice_id")
//     private invoice invoiceS;

    @Column(name = "invoice_detail_id") //PK   //se me estaba pasando añadir este anotation y su geter
    private Long invoiceDetailId;
    // @Schema(hidden = true, description = "", example = "", requiredMode = "")
    // private Long id; //este esta de mas(además es Integer) pero no afecta por que ya está el de invoice_id que es una de las dos fk junto a product_id  y su PK invoice_detail_id
    @Column(name = "amount")
    private Integer amount;  //Este no es el Long porque no es la PK Es integer
    @Schema(hidden = true, description = "p1", example = "2", requiredMode = "3")
    @Column(name = "price")//faltaban crear los anotations o@Columns de desde invoice_detail_id hasta price 
    private Double price;    //y obvio sus getter y setter respectivos de estos(bueno los get y setter de estos 3 ya estaban solo faltaba realmente el de invoice_detail_id o sea el de la PK uno de los mas importantes)

    @ManyToOne        //relaciones a tabla products   y en la tabla products estará de regreso
    @JoinColumn(name = "invoice_id") //fk  //faltaba la relacion de esta  tambien con la tabla products de la clase del mismo nombre checar si no hace conflicto que se llamen igual la tabla y la clase(No afecta pero lo mejor y mas recomendable es que sean diferentes nombres para no confundirlos)
    private invoices invoice;//lo mejor es que se llamen diferente la clase a su variable de referencia y al de la tabla su campo que tiene fk si se debe llamar por lógica diferente a todo lo demás

    @ManyToOne  
    @JoinColumn(name = "product_id")
    private products product;
    
//constructor vacio y con parametros
    public invoice_details() { }


    public invoice_details(invoices invoice,Long invoiceDetailId ,Integer amount, products product, Double price) {
        this.invoice=invoice;
        this.invoiceDetailId=invoiceDetailId;
        this.amount = amount;
        this.product = product;
        this.price = price;
        
       
    }
//getter-setter
    // public Long getId() { es Integer porque ya hay un Long que es la pk
    //     return id;
    // }

    // public void setId(Long id) {  lo mismo
    //     this.id = id;
    // }


    public Long getInvoiceDetailId() {  //faltaba los get y set de este 
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(Long invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public Integer getAmount() { //no es long sino Integer como pusimos arriba
        return amount;
    }

    public void setAmount(Integer amount) { //ni tampoco aqui, por eso y lo anotado arriba no creaba esta tabla estaban mal los tipos no en la tabla sino aquí
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public invoices getInvoice() {  ///faltaban los get y set
        return invoice;
    }

    public void setInvoice(invoices invoice) {
        this.invoice = invoice;
    }

    public products getProduct() {
        return product;
    }

    public void setProduct(products product) {
        this.product = product;
    }
}