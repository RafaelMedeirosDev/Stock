package com.estudos.stock.services.product;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Product;
import com.estudos.stock.respositories.ProductRepository;
import com.estudos.stock.shared.dtos.CreateMovementDto;
import com.estudos.stock.shared.enums.MovementTypeEnum;

@Service
public class UpdateProductStockService {

    @Autowired
    private ProductRepository productRepository;

    public void execute(Product product, CreateMovementDto body) {
        if(body.movementType == MovementTypeEnum.ENTRY) {
            product.setStockQuantity(product.getStockQuantity() + body.amount);
        } else if(body.movementType == MovementTypeEnum.EXIT) {

            if(product.getStockQuantity() < body.amount) {
                throw new RuntimeException("Saída do produto é maior que o estoque");
            }
            product.setStockQuantity(product.getStockQuantity() - body.amount);
            
        }

        product.setUpdatedAt(new Date());
        productRepository.save(product);
    }
}
