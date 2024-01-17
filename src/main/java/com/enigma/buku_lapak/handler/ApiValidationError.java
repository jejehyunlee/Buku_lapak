package com.enigma.buku_lapak.handler;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/8/2023 01:05
@Last Modified 10/8/2023 01:05
Version 1.0
*/


import lombok.Data;

@Data

class ApiValidationError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String field, String message,Object rejectedValue,String object) {

        this.object = object;
        this.message = message;
        this.rejectedValue=rejectedValue;
        this.field = field;
    }


}