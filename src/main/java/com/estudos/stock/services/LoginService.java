package com.estudos.stock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Credential;
import com.estudos.stock.shared.dtos.LoginResponseDto;

@Service
public class LoginService {
    // @Autowired
    // private CredentialRepository credentialRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    // @Autowired
    // private EmployeeRepository employeeRepository;

    public ResponseEntity<LoginResponseDto> execute(Credential data) throws  Exception {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        
        var token = tokenService.generateToken((Credential) auth.getPrincipal());
        
        return ResponseEntity.ok(new LoginResponseDto(token));

    }

}
