package com.estudos.stock.shared.enums;

public enum  Role {
    MANAGER("Manager"),
    ATTENDANT("Attendant");

    private final String role;

    Role(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
}