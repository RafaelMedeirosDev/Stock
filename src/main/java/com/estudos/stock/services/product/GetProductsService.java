package com.estudos.stock.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Product;
import com.estudos.stock.respositories.ProductRepository;

@Service
public class GetProductsService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> execute() {
        return this.productRepository.getAllProducts();
    }
}
