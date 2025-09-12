package com.estudos.stock.services.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Product;
import com.estudos.stock.respositories.ProductRepository;
import com.estudos.stock.shared.dtos.LowStockProductDto;

@Service
public class LowStockReportService {
    @Autowired
    private ProductRepository productRepository;

    public List <LowStockProductDto> execute() {
        
        List<Product> allProducts = productRepository.getAllProducts();

        return allProducts.stream()
                .filter(product -> product.getStockQuantity() <= 10)
                .map(product -> new LowStockProductDto(product.getName(), product.getStockQuantity()))
                .toList();
    } 
}
