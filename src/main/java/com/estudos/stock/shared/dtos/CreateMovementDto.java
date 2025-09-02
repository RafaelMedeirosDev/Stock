package com.estudos.stock.shared.dtos;

import com.estudos.stock.shared.enums.MovementTypeEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateMovementDto {
    @NotNull(message= "movement type is not optional")
    public MovementTypeEnum movementType;
    @NotBlank(message= "product id is not optional")
    public String productId;
    public int amount;
}