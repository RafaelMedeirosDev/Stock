package com.estudos.stock.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.stock.domains.Movement;

public interface MovementRepository extends JpaRepository<Movement, String> {

}
