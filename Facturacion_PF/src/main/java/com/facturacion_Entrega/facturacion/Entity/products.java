package com.facturacion_Entrega.facturacion.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "products")
public class products {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Schema(hidden = true, description = "", example = "", requiredMode = "")
    private String description;
    @Schema(hidden = true, description = "", example = "", requiredMode = "")
    private String code;
    @Schema(hidden = true, description = "", example = "", requiredMode = "")
    private Long stock;
    @Schema(hidden = true, description = "", example = "", requiredMode = "")
    private Double price;

    @OneToMany(mappedBy = "product")//mapea a product NO a products ese era el error(que es la tabla)o sea siempre a la variable de la clase invocice_details
    @JsonIgnore   //no a product_id ni a id sino siempre la variable que refiere a la clase
    private List<invoice_details> invoiceDetails; //invoice_details es la clase

    //constructor vacío y con argumentos --buenas prácticas de Java, siempre va
    public products() {}

    public products(Long id, String description, String code, Long stock, Double price) {
        this.productId = id;
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Long getStock() {
        return stock;
    }

    public void setStock(Object newStockWithSell) {
        this.stock = (Long) newStockWithSell;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<invoice_details> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<invoice_details> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
}