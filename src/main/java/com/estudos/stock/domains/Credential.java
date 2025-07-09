package com.estudos.stock.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name= "credential")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Credential {
    @Id @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    @Column
    private String email;
    @Column
    private String password;

    public Credential(String email, String password){
        this.email = email;
        this.password = password;
    }
}
