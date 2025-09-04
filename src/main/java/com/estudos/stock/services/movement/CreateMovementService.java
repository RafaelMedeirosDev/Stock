package com.estudos.stock.services.movement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Movement;
import com.estudos.stock.domains.Product;
import com.estudos.stock.respositories.MovementRepository;
import com.estudos.stock.respositories.ProductRepository;
import com.estudos.stock.services.product.UpdateProductStockService;
import com.estudos.stock.shared.dtos.CreateMovementDto;

@Service
public class CreateMovementService {

    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UpdateProductStockService updateProductStockService;

    public Movement execute(CreateMovementDto body) {

        Product product = productRepository.findById(body.productId)
        .orElseThrow(() -> new RuntimeException("Product not found"));

        updateProductStockService.execute(product, body);

        Movement movement = new Movement(body.movementType, product, body.amount);
        return this.movementRepository.save(movement);
    }
}

