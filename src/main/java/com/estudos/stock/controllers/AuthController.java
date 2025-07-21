package com.estudos.stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.stock.domains.Credential;
import com.estudos.stock.services.LoginService;
import com.estudos.stock.shared.dtos.CreateCredentialDto;
import com.estudos.stock.shared.dtos.LoginResponseDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/log")
    public ResponseEntity<LoginResponseDto> login(@Validated  @RequestBody CreateCredentialDto body) throws Exception {
        ResponseEntity<LoginResponseDto> response = this.loginService.execute(new Credential(body.email, body.password));
        return response;
    }

}
