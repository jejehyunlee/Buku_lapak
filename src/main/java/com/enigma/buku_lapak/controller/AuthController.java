package com.enigma.buku_lapak.controller;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/3/2023 09:12
@Last Modified 10/3/2023 09:12
Version 1.0
*/

import com.enigma.buku_lapak.model.request.AuthRequest;
import com.enigma.buku_lapak.model.response.CommonResponse;
import com.enigma.buku_lapak.model.response.LoginResponse;
import com.enigma.buku_lapak.model.response.RegisterResponse;
import com.enigma.buku_lapak.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody AuthRequest request) {
        RegisterResponse register = authService.register(request);
        CommonResponse<Object> response = CommonResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("successfully registered")
                .data(register)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        LoginResponse loginResponse = authService.login(request);
        CommonResponse<Object> response = CommonResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Successfully Login")
                .data(loginResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }


}

