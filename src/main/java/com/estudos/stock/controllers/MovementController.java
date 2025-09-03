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

import com.estudos.stock.domains.Movement;
import com.estudos.stock.services.movement.CreateMovementService;
import com.estudos.stock.services.movement.GetMovementsService;
import com.estudos.stock.shared.dtos.CreateMovementDto;

@RestController
@RequestMapping("/movements")
public class MovementController {
    
    @Autowired
    private CreateMovementService createMovementService;
    @Autowired
    private GetMovementsService getMovementsService;

    @PostMapping
    public ResponseEntity<Movement> register(@RequestBody CreateMovementDto body){
        Movement movement = createMovementService.execute(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(movement);
    }

    @GetMapping
    public List<Movement> getAll(){
        return this.getMovementsService.execute();
    }
}

