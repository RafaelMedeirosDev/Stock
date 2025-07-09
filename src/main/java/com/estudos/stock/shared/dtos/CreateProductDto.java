package com.estudos.stock.shared.dtos;

import java.math.BigDecimal;

import com.estudos.stock.shared.enums.ProductCategoryEnum;
import com.estudos.stock.shared.enums.ProductMeasurementEnum;

import lombok.Data;

@Data
public class CreateProductDto {
    public ProductCategoryEnum productCategory;
    public String name;
    public int volume;
    public ProductMeasurementEnum productMeasurement;
    public String mark;
    public BigDecimal value;
}

