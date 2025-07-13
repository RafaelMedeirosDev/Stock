package com.estudos.stock.shared.dtos;

import com.estudos.stock.domains.Product;
import com.estudos.stock.shared.enums.MovementTypeEnum;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateMovementDto {
    @NotBlank(message= "movement type is not optional")
    public MovementTypeEnum movementType;
    @NotBlank(message= "product id is not optional")
    public Product productId;
    public int amount;
}