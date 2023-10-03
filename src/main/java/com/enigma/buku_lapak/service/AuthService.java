package com.enigma.buku_lapak.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 14:57
@Last Modified 10/2/2023 14:57
Version 1.0
*/


import com.enigma.buku_lapak.model.request.AuthRequest;
import com.enigma.buku_lapak.model.request.RegisterSellerRequest;
import com.enigma.buku_lapak.model.response.LoginResponse;
import com.enigma.buku_lapak.model.response.RegisterResponse;

public interface AuthService {

    RegisterResponse register(AuthRequest authRequest);

    RegisterResponse registerAdmin(AuthRequest authRequest);

    RegisterResponse registerSeller(RegisterSellerRequest registerSellerRequest);

    LoginResponse login(AuthRequest authRequesta);

}
