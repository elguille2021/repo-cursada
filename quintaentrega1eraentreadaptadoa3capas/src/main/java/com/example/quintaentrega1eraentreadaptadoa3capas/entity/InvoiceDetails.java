package com.example.quintaentrega1eraentreadaptadoa3capas.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private Long invoiceDetailId;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "price")
    private Double price;

    @ManyToOne        //relaciones a tabla products   y en la tabla prodcts estará de regreso
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//constructor vacio y con parametros
    public InvoiceDetails(){}

    public InvoiceDetails(Long invoiceDetailId, Integer amount, Double price, Invoice invoice, Product product) {
        this.invoiceDetailId = invoiceDetailId;
        this.amount = amount;
        this.price = price;
        this.invoice = invoice;
        this.product = product;
    }
//getter-setter
    public Long getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(Long invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    

}
