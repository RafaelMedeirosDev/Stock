package com.estudos.stock.shared.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductExitReportDto {
    private String productName;
    private Integer totalExits;

    public ProductExitReportDto(String productName, Integer totalExits) {
        this.productName = productName;
        this.totalExits = totalExits;
    }
}
