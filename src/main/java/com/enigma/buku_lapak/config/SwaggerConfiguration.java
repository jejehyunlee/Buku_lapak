//package com.enigma.buku_lapak.config;
//
///*
//Created By IntelliJ IDEA 2022.1.3 (Community Edition)
//Build #IC-221.5921.22, built on June 21, 2022
//@Author JEJE a.k.a Jefri S
//Java Developer
//Created On 9/21/2023 12:50
//@Last Modified 9/21/2023 12:50
//Version 1.0
//*/
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//@Configuration
//@EnableSwagger2
//@ConfigurationProperties("app.api")
//@ConditionalOnProperty(name="app.api.swagger.enable", havingValue = "true", matchIfMissing = false)
//public class SwaggerConfiguration {
//
//        @Bean
//        public Docket api() {
//            return new Docket(DocumentationType.SWAGGER_2)
//                    .select()
//                    .apis(RequestHandlerSelectors.any())
//                    .paths(PathSelectors.any())
//                    .build();
//        }
//    }
//
