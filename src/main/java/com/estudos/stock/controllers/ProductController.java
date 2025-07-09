package com.estudos.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.stock.domains.Product;
import com.estudos.stock.respositories.ProductRepository;
import com.estudos.stock.shared.dtos.CreateProductDto;
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product register(@RequestBody CreateProductDto body) {
        Product product = new Product(body.productCategory, body.name, body.volume, body.productMeasurement, body.mark, body.value);
        return this.productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return  this.productRepository.getAllProducts();
    }
}
