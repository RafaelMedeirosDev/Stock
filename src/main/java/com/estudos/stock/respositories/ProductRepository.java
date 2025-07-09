package com.estudos.stock.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estudos.stock.domains.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value= "SELECT * FROM product order by name ASC", nativeQuery = true)
    List<Product> getAllProducts();
 
}
