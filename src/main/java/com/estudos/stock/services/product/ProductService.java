package com.estudos.stock.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Product;
import com.estudos.stock.respositories.ProductRepository;
import com.estudos.stock.shared.dtos.CreateProductDto;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product execute(CreateProductDto body) {
        Product product = new Product(body.productCategory, body.name, body.volume, body.productMeasurement, body.mark, body.value);
        return this.productRepository.save(product);
    }
}


