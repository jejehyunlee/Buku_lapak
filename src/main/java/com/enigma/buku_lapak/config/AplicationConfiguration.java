package com.enigma.buku_lapak.config;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 10:24
@Last Modified 10/2/2023 10:24
Version 1.0
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AplicationConfiguration {

@Bean
    public ObjectMapper objectMapper(){
    return new ObjectMapper();
}


}
