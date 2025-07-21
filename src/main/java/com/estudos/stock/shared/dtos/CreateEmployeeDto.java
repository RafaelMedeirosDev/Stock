package com.estudos.stock.shared.dtos;



import com.estudos.stock.shared.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateEmployeeDto {
    @NotBlank(message= "name is not optional")
    public String name;
    @NotBlank(message= "cpf is not optional")
    public String cpf;
    @NotBlank(message= "email is not optional")
    @Email(message= "invalid email")
    public String email;
    @NotBlank(message= "password is not optional")
    @Size(min= 3)
    public String password;
    @NotNull(message= "role is not optional")
    public Role role;
}

