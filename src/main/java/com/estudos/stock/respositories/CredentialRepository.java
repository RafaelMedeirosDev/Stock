package com.estudos.stock.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.stock.domains.Credential;

public interface CredentialRepository extends JpaRepository<Credential, String>{
    Credential findByEmail(String email);
}
