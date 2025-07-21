package com.estudos.stock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Credential;
import com.estudos.stock.respositories.CredentialRepository;
import com.estudos.stock.shared.enums.Role;

@Service
public class CreateCredentialService {
    @Autowired
    private CredentialRepository credentialRepository;

    public Credential execute (String email, String password, Role role){
        Credential credentialByEmail = this.credentialRepository.findByEmail(email);

        if(credentialByEmail != null){
            throw new RuntimeException("Email already registered");
        }

        String hashedPassword = new BCryptPasswordEncoder().encode(password);
        Credential credential = new Credential(email, hashedPassword, role);
        return this.credentialRepository.save(credential);
    }
}
