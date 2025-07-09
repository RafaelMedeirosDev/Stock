package com.estudos.stock.shared.dtos;

import com.estudos.stock.shared.enums.MovementTypeEnum;

import lombok.Data;

@Data
public class CreateMovementDto {
    public MovementTypeEnum movementType;
    public String productId;
    public int amount;
}