package com.enigma.buku_lapak.model.response;

import lombok.*;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 13:12
@Last Modified 10/2/2023 13:12
Version 1.0
*/
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SellerResponse {

    private String username;

    private String email;

    private StoreResponse storeResponse;

}
