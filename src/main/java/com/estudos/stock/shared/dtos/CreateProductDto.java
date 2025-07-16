package com.estudos.stock.shared.dtos;

import java.math.BigDecimal;

import com.estudos.stock.shared.enums.ProductCategoryEnum;
import com.estudos.stock.shared.enums.ProductMeasurementEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProductDto {
    @NotNull(message= "category type is not optional")
    public ProductCategoryEnum productCategory;
    @NotBlank(message="name is not optional")
    public String name;
    public int volume;
    public ProductMeasurementEnum productMeasurement;
    public String mark;
    public BigDecimal value;
}

