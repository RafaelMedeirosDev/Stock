package com.estudos.stock.domains;

import java.util.Date;

import com.estudos.stock.shared.enums.MovementTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "movement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movement {
    @Id @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    @Column(name= "movement_type")
    private MovementTypeEnum movementType;
    @Column(name= "product_id")
    private String productId;
    @Column
    private int amount;
    @Column(name= "movement_date")
    private Date movementDate;

    public Movement(MovementTypeEnum movementType, String productId, int amount){
        this.movementType = movementType;
        this.productId = productId;
        this.amount = amount;
        this.movementDate = new Date();
    }
}
