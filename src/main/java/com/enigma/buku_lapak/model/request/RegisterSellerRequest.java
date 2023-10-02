package com.enigma.buku_lapak.model.request;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 11:47
@Last Modified 10/2/2023 11:47
Version 1.0
*/

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class RegisterSellerRequest {

    @NotBlank(message = "email required")
    @Email(message = "Email Not Valid")
    private String email;
    private String password;
    private String username;
    private String storeName;
    private String mobilePhone;
}
