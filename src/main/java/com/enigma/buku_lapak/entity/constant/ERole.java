package com.enigma.buku_lapak.entity.constant;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 10:27
@Last Modified 10/2/2023 10:27
Version 1.0
*/


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public enum ERole {
    ROLE_CUSTOMER,
    ROLE_ADMIN,
    ROLE_SELLER;

    public static ERole get(String value){
        for (ERole erols: ERole.values())
        {
            if (erols.name().equalsIgnoreCase(value))
                return erols;
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"ROLE NOt FOUND");
    }

}
