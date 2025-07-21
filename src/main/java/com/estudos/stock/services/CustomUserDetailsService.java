package com.estudos.stock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Credential;
import com.estudos.stock.respositories.CredentialRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CredentialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential user = credencialRepository.findByEmail(username);
        
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
