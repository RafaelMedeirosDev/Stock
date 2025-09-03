package com.estudos.stock.services.movement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.estudos.stock.domains.Product;
import com.estudos.stock.respositories.ProductRepository;
import com.estudos.stock.shared.dtos.CreateMovementDto;
import com.estudos.stock.shared.enums.MovementTypeEnum;

public class UpdateProductStockService {

    @Autowired
    private ProductRepository productRepository;

    public void execute(Product product, CreateMovementDto body) {
        if(body.movementType == MovementTypeEnum.ENTRY) {
            product.setVolume(product.getVolume() + body.amount);
        } else {
            product.setVolume(product.getVolume() - body.amount);
        }

        product.setUpdatedAt(new Date());
        productRepository.save(product);
    }
}
