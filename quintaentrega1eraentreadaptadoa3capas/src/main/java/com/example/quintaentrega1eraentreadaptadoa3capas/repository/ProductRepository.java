package com.example.quintaentrega1eraentreadaptadoa3capas.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.quintaentrega1eraentreadaptadoa3capas.entity.Product;

//public class ProductRepository {  //No olvidar poner la annotation que corresponda en este caso @Repository
@Repository
    public interface ProductRepository extends JpaRepository<Product, Long>{

}    

