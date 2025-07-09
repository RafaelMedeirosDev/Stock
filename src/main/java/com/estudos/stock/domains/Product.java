package com.estudos.stock.domains;



import java.math.BigDecimal;
import java.util.Date;

import com.estudos.stock.shared.enums.ProductCategoryEnum;
import com.estudos.stock.shared.enums.ProductMeasurementEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    @Column(name="product_category")
    private ProductCategoryEnum productCategory;
    @Column
    private String name;
    @Column
    private int volume;
    @Column(name="product_measurement")
    private ProductMeasurementEnum productMeasurement;
    @Column
    private String mark;
    @Column(precision=10, scale=2)
    private BigDecimal value;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;

    public Product (ProductCategoryEnum productCategory, String name, int volume, ProductMeasurementEnum productMeasurement, String mark, BigDecimal value){
        this.productCategory = productCategory;
        this.name = name;
        this.volume = volume;
        this.productMeasurement = productMeasurement;
        this.mark = mark;
        this.value = value;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }



}
