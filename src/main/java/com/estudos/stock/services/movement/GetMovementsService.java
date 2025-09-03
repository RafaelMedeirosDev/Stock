package com.estudos.stock.services.movement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Movement;
import com.estudos.stock.respositories.MovementRepository;

@Service
public class GetMovementsService {

    @Autowired
    private MovementRepository movementRepository;

    public List<Movement> execute() {
        return this.movementRepository.getAll();
    }
}
