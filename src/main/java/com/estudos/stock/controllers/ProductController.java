package com.estudos.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.stock.domains.Product;
import com.estudos.stock.services.product.GetProductsService;
import com.estudos.stock.services.product.ProductService;
import com.estudos.stock.shared.dtos.CreateProductDto;
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private GetProductsService getProductsService;
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> register(@RequestBody CreateProductDto body) {
        Product product = productService.execute(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return  this.getProductsService.execute();
    }
}
