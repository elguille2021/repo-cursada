package com.primeraentrega.primeraentrega.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="products")
public class products { //como el profe dijo la clase se puede llamar igual a la tabla solo hay que tener cuidado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private  String description;

    private  String code;

    private Integer stock;

    private Double price;

    public products(Integer id) {
        this.id = id;
    }

    public products(Integer id, String description, String code, Integer stock, Double price) {
        this.id = id;
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

   

