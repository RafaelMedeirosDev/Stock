package com.estudos.stock.services.movement;

import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Product;
import com.estudos.stock.shared.dtos.CreateMovementDto;
import com.estudos.stock.shared.enums.MovementTypeEnum;

@Service
public class ValidateStockService {

    public void execute(Product product, CreateMovementDto body) {
        if(body.movementType == MovementTypeEnum.EXIT && product.getVolume() < body.amount) {
            throw new RuntimeException("Insufficient stock");
        }
    }
}
