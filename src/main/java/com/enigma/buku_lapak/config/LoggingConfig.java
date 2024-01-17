package com.enigma.buku_lapak.config;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/6/2023 12:09
@Last Modified 10/6/2023 12:09
Version 1.0
*/

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class LoggingConfig {

    @Getter
    private static String flagLogging;  //additionForLogging


    @Value("${flag.logging}")
    private void setFlagLogging(String flagLogging) {
        LoggingConfig.flagLogging = flagLogging;
    }

}
