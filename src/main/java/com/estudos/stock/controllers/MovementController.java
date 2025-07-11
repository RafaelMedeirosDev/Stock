package com.estudos.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.stock.domains.Movement;
import com.estudos.stock.respositories.MovementRepository;
import com.estudos.stock.shared.dtos.CreateMovementDto;

@RestController
@RequestMapping("/movements")
public class MovementController {
    
    @Autowired
    private MovementRepository movementRepository;

    @PostMapping
    public Movement register(@RequestBody CreateMovementDto body){
        Movement movement = new Movement(body.movementType, body.productId, body.amount);
        return this.movementRepository.save(movement);
    }

    @GetMapping
    public List<Movement> getAll(){
        return this.movementRepository.getAll();
    }
}

