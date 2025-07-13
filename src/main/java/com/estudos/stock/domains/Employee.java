 package com.estudos.stock.domains;

import com.estudos.stock.shared.enums.EmployeeCategoryEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Entity(name= "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    @Column
    private String name;
    @Column
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "credential_id", insertable = false, updatable = false)
    private Credential credentialId;
    @Enumerated(EnumType.STRING)
    @Column(name= "employee_category")
    private EmployeeCategoryEnum employeeCategory;

    public Employee(String name, String cpf, Credential credentialId, EmployeeCategoryEnum employeeCategory){
        this.name = name;
        this.cpf = cpf;
        this.credentialId = credentialId;
        this.employeeCategory = employeeCategory;
    }
}
