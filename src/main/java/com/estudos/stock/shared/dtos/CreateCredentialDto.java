package com.estudos.stock.shared.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCredentialDto {
    @NotBlank(message= "email is not optional")
    public String email;
    @NotBlank(message= "password is not optional")
    @Size(min=3)
    public String password;
}
