package com.estudos.stock.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estudos.stock.domains.Movement;

public interface MovementRepository extends JpaRepository<Movement, String> {

    @Query(
            value = """
        SELECT 
            m.id,
            m.product_id,
            m.movement_type,
            m.amount,
            m.movement_date
        FROM movement m
        JOIN product p ON p.id = m.product_id
        ORDER BY m.movement_date DESC
        """,
            nativeQuery = true
    )
    List<Movement> getAll();
}
  