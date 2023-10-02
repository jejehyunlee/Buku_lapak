package com.enigma.buku_lapak.security;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 14:35
@Last Modified 10/2/2023 14:35
Version 1.0
*/

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BCryptUtils {

    private final PasswordEncoder passwordEncoder;

    public String hashPassword(String password){
        return passwordEncoder.encode(password);
    }

}
