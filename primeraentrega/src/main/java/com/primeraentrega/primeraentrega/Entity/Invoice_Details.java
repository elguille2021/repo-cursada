package com.primeraentrega.primeraentrega.Entity;

import jakarta.persistence.*; //el * hace un scope de todas las importaciones para no  importar cada uno como paso en Invoice

@Entity
@Table(name = "invoice_details")
public class Invoice_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @OneToOne
    @Column(name = "invoice_id")
    private Invoice invoice;

    private Integer amount;
    @ManyToOne
    @Column(name = "product_id")
    private products product;
    private Double price;

    public Invoice_Details( ) {
    }

    public Invoice_Details(Integer id, Invoice invoice, Integer amount, products product, Double price) {
        this.id = id;
        this.invoice = invoice;
        this.amount = amount;
        this.product = product;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public products getProduct() {
        return product;
    }

    public void setProduct(products product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

