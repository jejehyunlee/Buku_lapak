package com.enigma.buku_lapak.model.request;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/22/2023 15:58
@Last Modified 9/22/2023 15:58
Version 1.0
*/

import com.enigma.buku_lapak.entity.UserCredential;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CustomerRequest {

    private String idCustomer;

    @NotBlank
    private String nameCustomer;
    @NotBlank
    private String address;
    @NotBlank
    private String mobilePhoneCustomer;
    @NotBlank
    private String email;

    @OneToOne
    @JoinColumn(name = "user_credential_id")
    private UserCredential userCredential;

}
